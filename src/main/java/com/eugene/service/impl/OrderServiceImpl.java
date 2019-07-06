package com.eugene.service.impl;

import com.eugene.Enum.OrderStatusEnum;
import com.eugene.Enum.PaymentTypeEnum;
import com.eugene.common.annotation.ExceptionTransactional;
import com.eugene.common.exception.BusinessException;
import com.eugene.dao.OrderDAO;
import com.eugene.dao.OrderFlowOperationDAO;
import com.eugene.dto.OrderFlowOperationDTO;
import com.eugene.exception.OrderOperationException;
import com.eugene.factory.OrderOperationFactory;
import com.eugene.model.Order;
import com.eugene.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private List<OrderFlowOperationDTO> accountOrderFlowOperations;

    @Autowired
    private List<OrderFlowOperationDTO> securedOrderFlowOperations;

    @Autowired
    private OrderFlowOperationDAO orderFlowOperationDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderOperationFactory orderOperationFactory;

    @Override
    @ExceptionTransactional
    public void updateOrderStatus(OrderStatusEnum status, Long orderId) throws BusinessException {
        Order order = orderDAO.getById(orderId);
        if (order == null) {
            throw new BusinessException("订单不存在");
        }

        logger.info("更新订单: 验证是否为合法操作, 当前交易类型为: [ " + order.getPaymentType() + " ]");
        if (!checkIsValidOperation(order, status)) {
            logger.error("更新订单: 不允许从 [ " + order.getStatus() + " ] 状态更新成 [ " + status + " ]");
            throw new BusinessException("非法操作");
        }

        try {
            order.setStatus(status);
            orderOperationFactory.get(status).execute(order);
        } catch (OrderOperationException orderOperationException) {
            throw new BusinessException(orderOperationException.getMessage());
        }
    }

    private boolean checkIsValidOperation(Order order, OrderStatusEnum targetStatus) {
        List<OrderFlowOperationDTO> orderFlowOperation = getOrderFlowOperationsByPaymentType(order.getPaymentType());
        for (OrderFlowOperationDTO operation : orderFlowOperation) {
            if (operation.getOrderStatus() == order.getStatus() && operation.getNextChangeableStatus() != null) {
                for (OrderStatusEnum status : operation.getNextChangeableStatusList()) {
                    if (status == targetStatus) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private List<OrderFlowOperationDTO> getOrderFlowOperationsByPaymentType(PaymentTypeEnum paymentType) {
        return paymentType == PaymentTypeEnum.ACCOUNT ? this.accountOrderFlowOperations : this.securedOrderFlowOperations;
    }
}
