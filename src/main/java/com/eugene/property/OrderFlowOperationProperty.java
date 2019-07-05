package com.eugene.property;

import com.eugene.Enum.PaymentTypeEnum;
import com.eugene.dao.OrderFlowOperationDAO;
import com.eugene.dto.OrderFlowOperationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class OrderFlowOperationProperty {

    @Autowired
    private OrderFlowOperationDAO orderFlowOperationDAO;

    @Bean(value = "accountOrderFlowOperations")
    public List<OrderFlowOperationDTO> initAccountOrderFlowOperations() {
        return orderFlowOperationDAO.findOrderFlowOperationDTOByPaymentType(PaymentTypeEnum.ACCOUNT);
    }

    @Bean(value = "securedOrderFlowOperations")
    public List<OrderFlowOperationDTO> initSecuredOrderFlowOperations() {
        return orderFlowOperationDAO.findOrderFlowOperationDTOByPaymentType(PaymentTypeEnum.SECURED);
    }
}