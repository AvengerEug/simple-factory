package com.eugene;

import com.eugene.anotation.EnableOrderFlowOperation;
import com.eugene.common.annotation.EnableCors;
import com.eugene.common.cache.RedisTemplateConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import com.eugene.common.annotation.EnableFilters;

/**
 * 简单工厂处理订单流程demo.
 */
@SpringBootApplication
@EnableOrderFlowOperation
@Import(value = {RedisTemplateConfiguration.class})
@EnableCors
@EnableAsync
@EnableFilters
public class AppEntrance {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AppEntrance.class);
        springApplication.run(args);
    }

    @Bean
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
