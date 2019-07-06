package com.eugene.dao;

import com.eugene.Enum.OrderStatusEnum;
import com.eugene.common.dao.BaseDAO;
import com.eugene.model.Order;

public interface OrderDAO extends BaseDAO<Order, Long> {

    void updateStatus(Long orderId, OrderStatusEnum status);
}
