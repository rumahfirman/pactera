package com.firman.exception.handler;

import com.firman.exception.ExceptionMessagesConstants;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Overrides default error handling mechanism to provide clear and sensible error messages to client.
 * Created by firman on 6/30/19.
 */
@ControllerAdvice
public class ResponseEntityExceptionHandlerExt extends ResponseEntityExceptionHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseEntityExceptionHandlerExt.class);


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest req)
    {
        if (ex.getMessage().contains(ExceptionMessagesConstants.CITY_UNDEFINED))
        {
            Map pathVariables = (Map) req.getAttribute("org.springframework.web.servlet.View.pathVariables", 0);
            String city = (String) pathVariables.get("city");
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format(ExceptionMessagesConstants.CITY_UNDEFINED, city));
            return handleExceptionInternal(ex, null, headers, HttpStatus.BAD_REQUEST, req);
        }
        else
        {
            return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, req);
        }
    }


}
