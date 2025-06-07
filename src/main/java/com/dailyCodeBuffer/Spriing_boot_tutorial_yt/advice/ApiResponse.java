package com.dailyCodeBuffer.Spriing_boot_tutorial_yt.advice;

import lombok.Data;

@Data
public class ApiResponse<T>{
    /*
    private boolean success;
    private T data;
    private ApiError error;

    public ApiResponse(){}

    public ApiResponse(boolean success , T data , ApiError error){
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<>(true , data , null);
    }

    public static <T> ApiResponse<T> failure(ApiError error){
        return new ApiResponse<>(false,null,error);
    }
     */
    private boolean success;
    private T data;
    private ApiError error;

    public ApiResponse(boolean success , T data , ApiError error){
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<>(true , data , null);
    }

    public static <T> ApiResponse<T> failure(ApiError error){
        return new ApiResponse<>(false,null,error);
    }
}
