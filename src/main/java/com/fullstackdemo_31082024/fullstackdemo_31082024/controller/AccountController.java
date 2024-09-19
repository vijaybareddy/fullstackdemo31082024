package com.fullstackdemo_31082024.fullstackdemo_31082024.controller;

import com.fullstackdemo_31082024.fullstackdemo_31082024.Service.AccountService;
import com.fullstackdemo_31082024.fullstackdemo_31082024.expcetion.AccountCreationFailedExpcetion;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.Account;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.WithdrawlRequest;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.List;

@RestController
    @CrossOrigin("*")
public class  AccountController {
     /*  @PostMapping(value="/api/createAccount",
                consumes = "application/json",
                produces = "application/json")
        public Account getAccountNumber(@RequestBody Account account)
                throws Exception {
            AccountService accountService=new AccountService();
            String accountNumber=accountService.createAccount(account);
            account.setAccountnumber(accountNumber);
            return account;
      /*  }
   @PostMapping(value="/api/createAccount",
            consumes = "application/json",
            produces = "application/json")
    public Account getaccountNumberUsingHibernate(@RequestBody Account account)
            throws Exception {
        AccountService accountService=new AccountService();
        String accountNumber=accountService.oneTOManyUsingHibernate(account);
        account.setAccountnumber(accountNumber);
        return account;
    }*/
    @PostMapping(value="/api/createAccount",
            consumes = "application/json",
            produces = "application/json")
    public Account getaccountNumberUsingHibernateFromUi(@RequestBody Account account)
            throws Exception {
        AccountService accountService=new AccountService();
        String accountNumber=accountService.OneToManyUsingHibernateFromUI(account);
        account.setAccountnumber(accountNumber);
        return account;
    }
    @GetMapping(value="/api/searchAccount/hibernate",
            consumes = "application/json",
            produces = "application/json")
    public Account searchAccount(@RequestHeader (name = "accountinput")
                                 String accountNumber) {
        AccountService accountService=new AccountService();
        return accountService.searchAccount(accountNumber);
    }

    @GetMapping(value="/api/searchAccount",
            consumes = "application/json",
            produces = "application/json")
    public Account searchAccountUsingJpa(@RequestHeader (name = "accountnumber")
                                         String accountNumber) {
        AccountService accountService=new AccountService();
        return accountService.searchAccountByJpa(accountNumber);
    }
    @PostMapping(value = "/api/withdraw", consumes = "application/json", produces = "application/json")
    public Account withdraw(@RequestBody WithdrawlRequest request) throws Exception {
        AccountService accountService=new AccountService();
        return accountService.withdraw(request);
    }



}