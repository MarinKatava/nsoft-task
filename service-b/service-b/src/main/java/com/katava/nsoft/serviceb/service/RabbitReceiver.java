package com.katava.nsoft.serviceb.service;

import com.katava.nsoft.serviceb.model.HttpMessage;

public interface RabbitReceiver {
    void receiveMessage(HttpMessage httpMessage);
}
