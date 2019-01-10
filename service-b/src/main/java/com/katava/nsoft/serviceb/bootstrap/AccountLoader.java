package com.katava.nsoft.serviceb.bootstrap;

import com.katava.nsoft.serviceb.model.Account;
import com.katava.nsoft.serviceb.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountLoader implements ApplicationListener<ContextRefreshedEvent>
{
    private AccountRepo accountRepo;

    @Autowired
    public AccountLoader(AccountRepo accountRepo)
    {
        this.accountRepo = accountRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        List<Account> list = accountRepo.findAll();
        if (list.isEmpty())
        {
            Account account = new Account();
            accountRepo.save(account);
        }
    }
}
