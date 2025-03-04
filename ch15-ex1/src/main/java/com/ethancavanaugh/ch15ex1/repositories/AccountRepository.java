package com.ethancavanaugh.ch15ex1.repositories;

import com.ethancavanaugh.ch15ex1.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends ListCrudRepository<Account, Long> {
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE account SET balance = :balance WHERE id = :id")
    void setBalance(long id, BigDecimal balance);
}
