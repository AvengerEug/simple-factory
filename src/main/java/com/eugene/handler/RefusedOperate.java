package com.eugene.handler;

import com.eugene.common.OrderStatusHandler;
import com.eugene.exception.OrderOperationException;


public class RefusedOperate implements OrderStatusHandler {

    @Override
    public void execute(Object object) throws OrderOperationException {
        System.out.println("处理卖家拒绝接单逻辑");
    }
}
