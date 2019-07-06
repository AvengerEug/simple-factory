package com.eugene.handler;

import com.eugene.common.OrderStatusHandler;
import com.eugene.dao.OrderDAO;
import com.eugene.exception.OrderOperationException;
import com.eugene.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToConfirmOperate implements OrderStatusHandler {

    private Logger logger = LoggerFactory.getLogger(ToConfirmOperate.class);

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public void execute(Object object) throws OrderOperationException {
        if (object instanceof Order) {
            logger.info("更新订单: 处理卖家接单逻辑");
            Order order = (Order)object;
            orderDAO.updateStatus(order.getOrderId(), order.getStatus());
            logger.info("更新订单: 更新成功" );
        }
    }
}
