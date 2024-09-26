package com.fullstackdemo_31082024.fullstackdemo_31082024.controller;

import com.fullstackdemo_31082024.fullstackdemo_31082024.Service.AccountService;
import com.fullstackdemo_31082024.fullstackdemo_31082024.Service.AtmService;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.Account;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.Atm;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.WithdrawlRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")

public class AtmController {
    @PostMapping(value="/api/createAtm",
            consumes = "application/json",
            produces = "application/json")
    public Atm getCardNumber(@RequestBody Atm atm)
            throws Exception{
        AtmService atmService=new AtmService();
        AccountService accountService=new AccountService();
        String cardnumber=atmService.createAtm(atm);
        atm.setCardNumber(cardnumber);
        return atm;
    }
    @PostMapping(value = "/api/validateAtm", consumes = "application/json", produces = "application/json")
    public boolean validateAtm(@RequestBody Atm atm) throws Exception {
        AtmService atmService = new AtmService();
        return atmService.validateAtmLogin(atm.getAccountNumber(), atm.getPin());
    }

}