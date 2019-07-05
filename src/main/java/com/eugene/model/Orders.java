package com.eugene.model;

import com.eugene.Enum.OrderStatusEnum;

public class Orders {

    private Long ordersId;
    private OrderStatusEnum status;

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }
}
