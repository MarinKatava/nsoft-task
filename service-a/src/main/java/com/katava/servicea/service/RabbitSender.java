package com.katava.servicea.service;

import com.katava.servicea.model.HttpMessage;

public interface RabbitSender {
    void send(HttpMessage message);
}
