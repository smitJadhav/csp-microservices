package com.csp.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFound extends Exception {

    public DataNotFound(String message) {
        super(message);
    }

    public DataNotFound(Class clazz, String message, String... searchParamsMap) {
        super(ExceptionUtil.generateMessage(clazz.getSimpleName(), message, ExceptionUtil.toMap(String.class, String.class, searchParamsMap)));
    }
}


