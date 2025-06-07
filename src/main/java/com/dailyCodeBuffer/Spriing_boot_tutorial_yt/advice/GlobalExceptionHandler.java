package com.dailyCodeBuffer.Spriing_boot_tutorial_yt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    /*@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request){
        ApiError error = new ApiError(ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(ApiResponse.failure(error), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleAllOtherExceptions(Exception ex , WebRequest request){
        ApiError error = new ApiError("Internal Server Error",ex.getLocalizedMessage());
        return new ResponseEntity<>(ApiResponse.failure(error) , HttpStatus.INTERNAL_SERVER_ERROR);
    }
    */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFound(ResourceNotFoundException e,WebRequest webRequest){
        ApiError error = new ApiError(e.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(ApiResponse.failure(error),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handeAllOtherExceptions(
            Exception e , WebRequest webRequest){
        ApiError error = new ApiError("Internal Server Error",e.getLocalizedMessage());
        return new ResponseEntity<>(ApiResponse.failure(error),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


