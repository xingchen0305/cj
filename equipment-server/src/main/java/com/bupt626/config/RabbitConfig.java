package com.bupt626.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by CJ on 2017/7/22.
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue cancelQueue() {
        return new Queue("cancel");
    }
}
