package com.fullstackdemo_31082024.fullstackdemo_31082024.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WithdrawlRequest {
    private String accountnumber;
    private double amount;
}