package com.eugene.common;

import com.eugene.exception.OrderOperationException;

public interface OrderStatusHandler {

    void execute(Object object) throws OrderOperationException;
}
