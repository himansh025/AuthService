package com.uber.authService.exception;

import lombok.*;

@Getter
@Setter
public class ErrorResponse {

    public ErrorResponse(String message, String error, int status) {
        this.message = message;
        this.error = error;
        this.status = status;
    }

    private  String message;
    private  String error;
    private  int status;

}
