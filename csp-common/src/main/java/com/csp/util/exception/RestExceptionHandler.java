package com.csp.util.exception;

import com.csp.model.ErrorDetails;
import feign.FeignException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@ResponseBody
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String DATA_NOT_FOUND = "Data not found";
    private static final String INTERNAL_SERVER_ERROR = "Internal serve error";
    private static final String UNAUTHORISED = "Unauthorised access";
    private static final String APPLICATION_EXCEPTION = "Application exception";
    private static final String FEIGN_EXCEPTION = "Feign exception";


/*    @ExceptionHandler({Exception.class})
    public final ErrorDetails handleUnknownException(Exception ex, WebRequest request) {
        return new ErrorDetails(520, APPLICATION_EXCEPTION, ex.getMessage(), new Date(), request.getDescription(false));
    }*/

    @ExceptionHandler({DataNotFound.class})
    public final ErrorDetails handleDataNotFoundException(Exception ex, WebRequest request) {
        return new ErrorDetails(HttpStatus.NOT_FOUND.value(), DATA_NOT_FOUND, ex.getMessage(), new Date(), request.getDescription(false));
    }

    @ExceptionHandler(FeignException.class)
    public final ErrorDetails handleFeignException(Exception ex, WebRequest request) {
        return new ErrorDetails(520, FEIGN_EXCEPTION, ex.getMessage(), new Date(), request.getDescription(false));
    }

}
