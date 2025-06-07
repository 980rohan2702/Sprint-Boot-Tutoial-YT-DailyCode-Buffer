package com.dailyCodeBuffer.Spriing_boot_tutorial_yt.advice;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ApiError {
    /*
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ApiError(String message , String details){
        this.message =message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }
     */
    private String message;
    private String details;
    private LocalDateTime timeStamp;

    public ApiError(String message,String details){
        this.message = message;
        this.details = details;
        this.timeStamp = LocalDateTime.now();
    }

}
