package com.dailyCodeBuffer.Spriing_boot_tutorial_yt.advice;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
