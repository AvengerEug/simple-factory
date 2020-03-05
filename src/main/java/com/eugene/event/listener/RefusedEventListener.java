package com.eugene.event.listener;

import com.eugene.event.RefusedEvent;
import com.eugene.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class RefusedEventListener implements ApplicationListener<RefusedEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    @Override
    public void onApplicationEvent(RefusedEvent event) {
        if (event.getSource() instanceof Order) {
            logger.info("异步处理拒绝接单后的逻辑, 比如发短信、email等等 ");
        }
    }
}
