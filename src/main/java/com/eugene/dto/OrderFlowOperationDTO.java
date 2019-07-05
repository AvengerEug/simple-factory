package com.eugene.dto;

import java.util.List;

import com.eugene.Enum.OrderOperationEnum;
import com.eugene.Enum.OrderStatusEnum;
import com.eugene.model.OrderFlowOperation;

public class OrderFlowOperationDTO extends OrderFlowOperation {

    private List<OrderOperationEnum> nextExecutableOperationList;
    private List<OrderStatusEnum> nextChangeableStatusList;

    public List<OrderOperationEnum> getNextExecutableOperationList() {
        return nextExecutableOperationList;
    }

    public void setNextExecutableOperationList(List<OrderOperationEnum> nextExecutableOperationList) {
        this.nextExecutableOperationList = nextExecutableOperationList;
    }

    public List<OrderStatusEnum> getNextChangeableStatusList() {
        return nextChangeableStatusList;
    }

    public void setNextChangeableStatusList(List<OrderStatusEnum> nextChangeableStatusList) {
        this.nextChangeableStatusList = nextChangeableStatusList;
    }

    @Override
    public String toString() {
        return "OrderFlowOperationDTO{" +
                "nextExecutableOperationList=" + nextExecutableOperationList +
                ", nextChangeableStatusList=" + nextChangeableStatusList +
                '}';
    }
}
