package com.csp.config;

import com.csp.model.ErrorDetails;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Smit.Jadhav on 01/03/2021
 */

@RestController
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ErrorDetails findError(HttpServletResponse response) {

        HttpStatus status = HttpStatus.valueOf(response.getStatus());
        return new ErrorDetails(response.getStatus(), status, status.getReasonPhrase());
    }

}
