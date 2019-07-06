package com.eugene.model;

import com.eugene.Enum.OrderStatusEnum;
import com.eugene.Enum.PaymentTypeEnum;

import java.math.BigDecimal;

public class Order {

    private Long orderId;
    private OrderStatusEnum status;
    private BigDecimal price;
    private PaymentTypeEnum paymentType;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }
}
