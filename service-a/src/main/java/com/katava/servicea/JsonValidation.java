package com.katava.servicea;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.katava.servicea.model.HttpMessage;

@Component
public class JsonValidation
{

    public ResponseEntity validate(HttpMessage httpMessage)
    {

        if (httpMessage.getAmount() == null || httpMessage.getCurrency() == null)
        {
            return new ResponseEntity<>("Define both, amount and currency", HttpStatus.BAD_REQUEST);
        }
        else if (httpMessage.getAmount() > 100000000 || httpMessage.getAmount() < -100000000 || !httpMessage
            .getCurrency().equals("EUR"))
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else
        {
            return null;
        }
    }
}
