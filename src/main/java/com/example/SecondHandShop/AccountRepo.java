package com.example.SecondHandShop;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {
    Account findByUsernameAndPassword(String username, String password);
    Account findByUsername(String username);


}
