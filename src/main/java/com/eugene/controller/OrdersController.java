package com.eugene.controller;

import com.eugene.Enum.OrderStatusEnum;
import com.eugene.Enum.PaymentTypeEnum;
import com.eugene.common.controller.BaseController;
import com.eugene.common.exception.BusinessException;
import com.eugene.common.web.http.Message;
import com.eugene.dao.OrderFlowOperationDAO;
import com.eugene.dto.OrderFlowOperationDTO;
import com.eugene.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/orders")
public class OrdersController extends BaseController {

    @Autowired
    private OrderService orderService;

    @PutMapping(value = "/update-status/{orderId}")
    public Message updateOrderStatus(
            @PathVariable(value = "orderId") Long orderId,
            @RequestParam(value = "status") OrderStatusEnum status) throws BusinessException {
        orderService.updateOrderStatus(status, orderId);
        return Message.ok();
    }
}
