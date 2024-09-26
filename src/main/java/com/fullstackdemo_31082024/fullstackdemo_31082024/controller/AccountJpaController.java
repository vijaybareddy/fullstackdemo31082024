package com.fullstackdemo_31082024.fullstackdemo_31082024.controller;

import com.fullstackdemo_31082024.fullstackdemo_31082024.Service.AccountServiceWithJpa;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.Account;
import entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AccountJpaController {

    @Autowired
    AccountServiceWithJpa accountServiceWithSpringJpa;
    @GetMapping(value = "/api/searchAccount/Jpql",
            consumes = "application/json",
            produces = "application/json")
    public Account getAccountByAccountAndPanJPQL(@RequestHeader("accountinput")
                                                 String accountnumber, @RequestHeader("paninput") String pan) {
        return accountServiceWithSpringJpa.searchAccountByAccountAndPan(accountnumber, pan);
   }
    @GetMapping(value = "/api/searchAccount/balance",
            consumes = "application/json",
            produces = "application/json")
    public List<AccountEntity> searchByBalance(@RequestHeader("balanceinput") double balance){
        return accountServiceWithSpringJpa.accountLessThanBalance(balance);
    }

    @GetMapping(value = "/api/searchAccount/balanceGreater",
            consumes = "application/json",
            produces = "application/json")
    public List<AccountEntity> searchByBalanceGreater(@RequestHeader("balanceinput") double balance){
        return accountServiceWithSpringJpa.accountGreaterThanBalance(balance);
    }

    @GetMapping(value = "/api/searchAccount/balanceRange",
            consumes = "application/json",
            produces = "application/json")
    public List<AccountEntity> searchByBalanceRange(@RequestHeader("lowerRangeinput") double lowerRange, @RequestHeader("upperRangeinput") double upperRange){
        return accountServiceWithSpringJpa.accountBetweenBalance(lowerRange, upperRange);
    }


//    @GetMapping(value = "/api/searchAccount/balanceNull")
//    public List<AccountEntity> getAccountsWithBalanceNull(){
//        return accountServiceWithSpringJpa.findAccountsWithNullBalance();
//    }
//
//    @GetMapping(value = "/api/searchAccount/balanceNotNull")
//    public List<AccountEntity> getAccountsWithBalanceNotNull(){
//        return accountServiceWithSpringJpa.findAccountsWithBalanceNotNull();
//    }
//
//    @GetMapping(value = "/api/searchAccount/distnctBalance")
//    public List<AccountEntity> getDistinctAccountsByBalance(@RequestHeader("balanceinput") double balance){
//        return accountServiceWithSpringJpa.findDistinctAccountsByBalance(balance);
//    }

}
