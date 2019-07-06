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

    @Bean
    public List<OrderFlowOperationDTO> accountOrderFlowOperations() {
        return orderFlowOperationDAO.findOrderFlowOperationDTOByPaymentType(PaymentTypeEnum.ACCOUNT);
    }

    @Bean
    public List<OrderFlowOperationDTO> securedOrderFlowOperations() {
        return orderFlowOperationDAO.findOrderFlowOperationDTOByPaymentType(PaymentTypeEnum.SECURED);
    }
}