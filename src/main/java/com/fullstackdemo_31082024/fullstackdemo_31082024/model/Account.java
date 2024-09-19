package com.fullstackdemo_31082024.fullstackdemo_31082024.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Data
@Builder

public class Account {
    private String name;
    private String accountnumber;
    private String pan;
    private String mobileNumber;
    private double balance;
    private Address address;




}

