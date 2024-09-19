package com.fullstackdemo_31082024.fullstackdemo_31082024.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Atm {
    private String cardNumber;
    private String pin;
    private String cvv;
    private Date expiry;
    private String accountNumber;

    public String getCardNumber() {

        return cardNumber;
    }

    public String getPin() {

        return pin;
    }

    public String getCvv() {
        return cvv;
    }

    public Date getExpiry() {
        return expiry;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
