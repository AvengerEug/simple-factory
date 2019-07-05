package com.eugene;

import com.eugene.common.cache.RedisTemplateConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * 简单工厂处理订单流程demo.
 */
@SpringBootApplication
/*@EnableOrderFlowOperation*/
@Import(value = {RedisTemplateConfiguration.class})
public class AppEntrance {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AppEntrance.class);
        springApplication.run(args);
    }
}
