package com.fullstackdemo_31082024.fullstackdemo_31082024.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {
    private String add1;
    private String add2;
    private String city;
    private String states;
    private String pincode;
}
