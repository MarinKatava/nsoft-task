package com.katava.servicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.katava.servicea.JsonValidation;
import com.katava.servicea.RoundAmount;
import com.katava.servicea.model.HttpMessage;
import com.katava.servicea.service.RabbitSender;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
    private final RabbitSender rabbitSender;
    private final JsonValidation jsonValidation;

    @Autowired
    public RestController(RabbitSender rabbitSender, JsonValidation jsonValidation)
    {
        this.rabbitSender = rabbitSender;
        this.jsonValidation = jsonValidation;
    }

    @PostMapping(value = "/message", consumes = "application/json")
    public ResponseEntity httpMessage(@RequestBody HttpMessage httpMessage)
    {
        ResponseEntity entity = jsonValidation.validate(httpMessage);
        if (entity != null)
        {
            return entity;
        }

        HttpMessage message = new HttpMessage();
        message.setAmount(new RoundAmount(httpMessage.getAmount()).getAmount());
        message.setCurrency(httpMessage.getCurrency());

        rabbitSender.send(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}


