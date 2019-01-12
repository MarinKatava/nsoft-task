package com.katava.nsoft.serviceb.service.serviceImpl;

import com.katava.nsoft.serviceb.model.Account;
import com.katava.nsoft.serviceb.model.HttpMessage;
import com.katava.nsoft.serviceb.repo.AccountRepo;
import com.katava.nsoft.serviceb.service.RabbitReceiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class RabbitReceiverImpl implements RabbitReceiver {

    private RabbitTemplate rabbitTemplate;

    private AccountRepo accountRepo;

    @Autowired
    public RabbitReceiverImpl(RabbitTemplate rabbitTemplate, AccountRepo accountRepo) {
        this.rabbitTemplate = rabbitTemplate;
        this.accountRepo = accountRepo;
    }

    @Override
    public void receiveMessage(HttpMessage httpMessage) {
        System.out.println("Received: " + httpMessage);
        saveMessage(httpMessage);
    }

    private void saveMessage(HttpMessage httpMessage) {

        Account account = new Account();
        account.setBalance(getBalance() + httpMessage.getAmount());
        account.setUpdatedAt(LocalDateTime.now(ZoneId.systemDefault()));
        accountRepo.save(account);
    }

    private Double getBalance() {
        Account account = accountRepo.findTopByOrderByIdDesc();
        return account.getBalance();
    }
}
