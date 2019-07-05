package com.eugene.dao.impl;

import com.eugene.Enum.PaymentTypeEnum;
import com.eugene.common.dao.mybatis.MyBatisDAO;
import com.eugene.dao.OrderFlowOperationDAO;
import com.eugene.dto.OrderFlowOperationDTO;
import com.eugene.model.OrderFlowOperation;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository(value = "orderFlowOperationDAO")
public class OrderFlowOperationDAOImpl extends MyBatisDAO<OrderFlowOperation, Long> implements OrderFlowOperationDAO {

    @Override
    public List<OrderFlowOperationDTO> findOrderFlowOperationDTOByPaymentType(PaymentTypeEnum paymentType) {
        return this.getSqlSession().selectList(this.getSqlNameSpace() + "findOrderFlowOperationDTOByPaymentType", paymentType.getValue());
    }
}
