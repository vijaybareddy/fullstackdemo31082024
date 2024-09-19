package com.fullstackdemo_31082024.fullstackdemo_31082024.expcetion;

public class AccountCreationFailedExpcetion extends Exception {
    public String message;
    public AccountCreationFailedExpcetion(String message){
this.message=message;
    }

}
