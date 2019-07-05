package com.eugene.controller;

import com.eugene.Enum.PaymentTypeEnum;
import com.eugene.dao.OrderFlowOperationDAO;
import com.eugene.dto.OrderFlowOperationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/orders")
public class OrdersController {

    /*@Autowired
    private List<OrderFlowOperationDTO> accountOrderFlowOperations;

    @Autowired
    private List<OrderFlowOperationDTO> securedOrderFlowOperations;*/


    @Autowired
    private OrderFlowOperationDAO orderFlowOperationDAO;

    @GetMapping(value = "/hello")
    public String hello() {
        /*for (OrderFlowOperationDTO orderFlowOperationDTO : accountOrderFlowOperations) {
            System.out.printf(orderFlowOperationDTO.toString());
        }

        for (OrderFlowOperationDTO ordeOrderFlowOperationMapperrFlowOperationDTO : securedOrderFlowOperations) {
            System.out.printf(orderFlowOperationDTO.toString());
        }*/
        orderFlowOperationDAO.findOrderFlowOperationDTOByPaymentType(PaymentTypeEnum.ACCOUNT);
        return "123";
    }
}
