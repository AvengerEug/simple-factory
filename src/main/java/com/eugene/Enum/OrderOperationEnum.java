package com.eugene.Enum;

public enum OrderOperationEnum {

    // 待接单  ->  卖家拒绝接单、买家取消接单、系统自动取消接单、卖家确认接单
    REFUSE_ORDER(0), CANCEL_ACCEPT_ORDER(1), AUTO_CANCEL_ACCEPT_ORDER(2), SURE_ACCEPT_ORDER(3),

    // 待付款  ->  买家付款、买家取消订单、自动取消订单
    PAYMENT(4), CANCEL_ORDER(5), PAYMENT_AUTO_CLOSE_ORDER(6),

    // 待发货  -> 确认发货、自动关闭订单
    SURE_SHIP(7), AUTO_CLOSE_ORDER(8),

    // 待收货 -> 确认收货、自动完成订单
    SURE_RECEIPT(9), AUTO_FINISH_ORDER(10),

    // 完成订单
    FINISHED(11);

    private int value;

    OrderOperationEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static OrderOperationEnum valueOf(int value) {
        for (OrderOperationEnum orderOperation : OrderOperationEnum.values()) {
            if (orderOperation.getValue() == value) {
                return orderOperation;
            }
        }

        return null;
    }
}
