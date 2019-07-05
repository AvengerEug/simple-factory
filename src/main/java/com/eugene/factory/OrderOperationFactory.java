package com.eugene.factory;

import com.eugene.common.OrderStatusHandler;
import com.eugene.exception.OrderOperationException;
import com.eugene.handler.RefusedOperate;
import com.eugene.handler.ToConfirmOperate;
import com.eugene.Enum.OrderStatusEnum;

public class OrderOperationFactory {

    private ToConfirmOperate toConfirmOperate = new ToConfirmOperate();

    private RefusedOperate refusedOperate = new RefusedOperate();

    /**
     * 根据订单要更新的状态 返回对应的处理器
     * @param orderToStatus
     * @return
     */
    public OrderStatusHandler get(OrderStatusEnum orderToStatus) throws OrderOperationException {
        switch (orderToStatus) {
            case TO_CONFIRM:
                return toConfirmOperate;
            case REFUSED:
                return refusedOperate;
            default:
                throw new OrderOperationException("0001", "订单目标状态不存在, 无法获取处理器");
        }
    }
}
