package com.eugene.service;

import com.eugene.Enum.OrderStatusEnum;
import com.eugene.common.exception.BusinessException;

public interface OrderService {

    void updateOrderStatus(OrderStatusEnum status, Long orderId) throws BusinessException;
}
