package com.katava.servicea.service.serviceImpl;

import com.katava.servicea.service.RabbitSender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.katava.servicea.model.HttpMessage;

@Service
public class RabbitSenderImpl implements RabbitSender
{
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitSenderImpl(RabbitTemplate rabbitTemplate)
    {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${queue}")
    String queueName;

    @Value("${exchange}")
    String exchange;

    @Value("${routingkey}")
    private String routingkey;

    @Override
    public void send(HttpMessage message)
    {
        rabbitTemplate.convertAndSend(queueName, message);
        System.out.println("Send msg = " + message);
    }
}
