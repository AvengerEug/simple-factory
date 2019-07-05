package com.eugene.dao;

import com.eugene.Enum.PaymentTypeEnum;
import com.eugene.common.dao.BaseDAO;
import com.eugene.dto.OrderFlowOperationDTO;
import com.eugene.model.OrderFlowOperation;

import java.util.List;

public interface OrderFlowOperationDAO extends BaseDAO<OrderFlowOperation, Long> {

    List<OrderFlowOperationDTO> findOrderFlowOperationDTOByPaymentType(PaymentTypeEnum paymentType);


}
