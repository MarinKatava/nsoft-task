package com.katava.servicea.config;

import com.katava.servicea.model.HttpMessage;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Value("${queue}")
    String queueName;

    @Value("${exchange}")
    String exchange;

    @Value("${routingkey}")
    private String routingkey;

    @Bean
    Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    public MessageConverter messageConverter() {
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        jackson2JsonMessageConverter.setClassMapper(new ClassMapper() {

            @Override
            public Class<?> toClass(MessageProperties properties) {
                return HttpMessage.class;
            }

            @Override
            public void fromClass(Class<?> clazz, MessageProperties properties) {

            }

        });
        return jackson2JsonMessageConverter;
    }

}
