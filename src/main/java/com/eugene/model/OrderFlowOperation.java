package com.eugene.model;

import com.eugene.Enum.OrderStatusEnum;
import com.eugene.Enum.PaymentTypeEnum;

import java.io.Serializable;

public class OrderFlowOperation implements Serializable {

    private Long orderFlowOperation;
    private String name;
    private OrderStatusEnum orderStatus;
    private PaymentTypeEnum paymentType;
    private String nextExecutableOperation;
    private String nextChangeableStatus;

    public Long getOrderFlowOperation() {
        return orderFlowOperation;
    }

    public void setOrderFlowOperation(Long orderFlowOperation) {
        this.orderFlowOperation = orderFlowOperation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }

    public String getNextExecutableOperation() {
        return nextExecutableOperation;
    }

    public void setNextExecutableOperation(String nextExecutableOperation) {
        this.nextExecutableOperation = nextExecutableOperation;
    }

    public String getNextChangeableStatus() {
        return nextChangeableStatus;
    }

    public void setNextChangeableStatus(String nextChangeableStatus) {
        this.nextChangeableStatus = nextChangeableStatus;
    }

    @Override
    public String toString() {
        return "OrderFlowOperation{" +
                "orderFlowOperation=" + orderFlowOperation +
                ", name='" + name + '\'' +
                ", orderStatus=" + orderStatus +
                ", paymentType=" + paymentType +
                ", nextExecutableOperation='" + nextExecutableOperation + '\'' +
                ", nextChangeableStatus='" + nextChangeableStatus + '\'' +
                '}';
    }
}