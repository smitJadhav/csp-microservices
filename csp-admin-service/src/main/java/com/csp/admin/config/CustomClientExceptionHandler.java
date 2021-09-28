package com.csp.admin.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author Smit.Jadhav on 01-08-2021.
 */

@Component
public class CustomClientExceptionHandler implements ErrorDecoder {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomClientExceptionHandler.class);

        //TODO: Add custom exception handling logic later

    @Override
    public Exception decode(String methodKey, Response response) {
        Response.Body responseBody = response.body();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        LOGGER.info("feign error decoder called");

        if (responseStatus.is5xxServerError()) {
            LOGGER.error("Status code = {}, methodKey = {}, responseBody = ", response.status(), methodKey, responseBody.toString());
            return new Exception(responseBody.toString());
        } else if (responseStatus.is4xxClientError()) {
            LOGGER.error("Status code = {}, methodKey = {}, responseBody = ", response.status(), methodKey, responseBody.toString());
            return new Exception(responseBody.toString());
        } else {
            return new Exception("Generic exception");
        }
    }
}
