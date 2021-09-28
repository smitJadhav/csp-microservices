package com.csp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private int statusCode;
    private String status;
    private String message;
    private Date timestamp;
    private String details;

    public ErrorDetails(int statusCode, String status, String message){
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }

}
