package com.eugene.Enum;

/**
 * 每个状态下面的可执行操作如下:
 *
 *   状态                           可执行操作(操作后的状态)
 * TO_CONFIRM             卖家拒绝接单(REFUSE), 卖家确认接单(TO_PAY), 买家取消订单(CANCELED), 72小时卖家不接单job自动关闭订单(CLOSE)
 * TO_PAY                 买家付款(TO_SHIP)， 取消订单(CANCELED), 72小时内买家不付款job自动关闭订单(CLOSE)
 * TO_SHIP                卖家确认发货(TO_ACCEPT), 120小时内卖家不发货job自动关闭订单并退款给买家
 * TO_ACCEPT              买家确认收货(FINISHED), 480小时内不收货job自动完成订单
 *
 * REFUSED                无操作
 * CANCELED               无操作
 * CLOSED                 无操作
 * FINISHED               无操作
 *
 * ps: job自动跑的设计是: 将job自动更改订单状态的task存入表中, 由job定时去查表, 查出所有激活状态的task数据, 再开始check逻辑
 */
public enum OrderStatusEnum {

    TO_CONFIRM(0), // 待接单
    REFUSED(1), // 拒绝接单
    CANCELED(2), // 买家取消
    TO_PAY(3), // 待支付
    CLOSED(4), // 已关闭
    TO_SHIP(5), // 待发货
    TO_ACCEPT(6), //待收货
    FINISHED(10); //完成

    private int value;

    public int getValue() {
        return this.value;
    }

    OrderStatusEnum (int value) {
        this.value = value;
    }

    public static OrderStatusEnum valueOf(int value) {
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (orderStatusEnum.value == value) {
                return orderStatusEnum;
            }
        }

        return null;
    }

}
