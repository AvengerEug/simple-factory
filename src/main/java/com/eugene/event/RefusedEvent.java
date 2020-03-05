package com.eugene.event;

import com.eugene.model.Order;
import org.springframework.context.ApplicationEvent;

public class RefusedEvent extends ApplicationEvent {

    public RefusedEvent(Order order) {
        super(order);
    }
}
