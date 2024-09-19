package com.fullstackdemo_31082024.fullstackdemo_31082024.expcetion;

public class AtmCreationFailedException extends Exception{
    public String message;
    public AtmCreationFailedException(String message){
        this.message=message;
    }

}
