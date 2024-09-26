package com.fullstackdemo_31082024.fullstackdemo_31082024.controller;

import com.fullstackdemo_31082024.fullstackdemo_31082024.Service.AccountService;
import com.fullstackdemo_31082024.fullstackdemo_31082024.expcetion.AccountCreationFailedExpcetion;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class AccountController {

    @Autowired
    AccountService accountServiceTest;

    @PostMapping(value = "/api/createAccount/jdbc",
            consumes = "application/json",
            produces = "application/json")

    public Account getAccountNumber(@RequestBody Account account)
            throws AccountCreationFailedExpcetion {

        AccountService accountService = new AccountService();
        String accountNumber = accountService.createAccountByJpa(account);
        account.setAccountnumber(accountNumber);
        return account;
    }

    @PostMapping(value = "/api/createAccount/singleTable",
            consumes = "application/json",
            produces = "application/json")

    public Account getAccountNumberHibernatesingleTable(@RequestBody Account account)
            throws AccountCreationFailedExpcetion {

        AccountService accountService = new AccountService();
        String accountNumber = accountService.createAccountUsingHibernate(account);
        account.setAccountnumber(accountNumber);
        return account;
    }

    @PostMapping(value = "/api/createAccount/hibernate",
            consumes = "application/json",
            produces = "application/json")

    public Account getAccountNumberHibernate(@RequestBody Account account)
            throws AccountCreationFailedExpcetion {

        AccountService accountService = new AccountService();
        String accountNumber = accountService.OneToManyUsingHibernateFromUI(account);
        account.setAccountnumber(accountNumber);
        return account;
    }

    @PostMapping(value = "/api/createAccount",
            consumes = "application/json",
            produces = "application/json")

    public Account getAccountNumberHibernatefromUI(@RequestBody Account account)
            throws AccountCreationFailedExpcetion {

        AccountService accountService = new AccountService();
        String accountNumber = accountService.OneToManyUsingHibernateFromUI(account);
        account.setAccountnumber(accountNumber);
        return account;
    }

    @GetMapping(value = "/api/searchAccount/hibernate",
            consumes = "application/json",
            produces = "application/json")

    public Account searchAccount(@RequestHeader("accountinput")
                                 String accountNumber) {

        //    List<String> accountNumberList = httpHeaders.get("accountinput");

        //   String accuntFromhttpHeader = accountNumberList.get(0);

        AccountService accountService = new AccountService();
        return accountService.searchAccount(accountNumber);

    }

    @GetMapping(value = "/api/searchAccount/nonmanagedjpa",
            consumes = "application/json",
            produces = "application/json")

    public Account searchAccountJPA(@RequestHeader("accountinput")
                                    String accountNumber) {

        //    List<String> accountNumberList = httpHeaders.get("accountinput");

        //   String accuntFromhttpHeader = accountNumberList.get(0);

        AccountService accountService = new AccountService();
        return accountService.searchAccountByJpa(accountNumber);

    }

    @GetMapping(value = "/api/searchAccount",
            consumes = "application/json",
            produces = "application/json")

    public Account searchAccountManagedJPA(@RequestHeader("accountinput")
                                           String accountNumber) {

        //    List<String> accountNumberList = httpHeaders.get("accountinput");

        //   String accuntFromhttpHeader = accountNumberList.get(0);


        return accountServiceTest.searchAccountByJpa(accountNumber);

    }

}