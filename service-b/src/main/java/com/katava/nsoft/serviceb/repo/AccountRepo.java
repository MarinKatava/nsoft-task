package com.katava.nsoft.serviceb.repo;

import com.katava.nsoft.serviceb.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>
{
    Account findTopByOrderByIdDesc();
}
