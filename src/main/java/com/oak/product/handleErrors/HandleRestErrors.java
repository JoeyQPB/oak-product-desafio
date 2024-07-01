package com.oak.product.handleErrors;

import com.oak.product.exceptions.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleRestErrors extends ResponseEntityExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(HandleRestErrors.class);

    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> exceptionHandler (Exception exception) {
        LOGGER.error("Error: Exception - " + exception.getMessage());
        RestErrorMessage<String> threatResponse = new RestErrorMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(threatResponse.httpStatus()).body("ControllerAdvice - " + threatResponse.body());
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<String> runtimeExceptionHandler (RuntimeException exception) {
        LOGGER.error("Error: RuntimeException - " + exception.getMessage());
        RestErrorMessage<String> threatResponse = new RestErrorMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(threatResponse.httpStatus()).body("ControllerAdvice - " + threatResponse.body());
    }

    @ExceptionHandler(NullPointerException.class)
    private ResponseEntity<String> nullPointerExceptionHandler (NullPointerException exception) {
        LOGGER.error("Error: NullPointerException - " + exception.getMessage());
        RestErrorMessage<String> threatResponse = new RestErrorMessage<>(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(threatResponse.httpStatus()).body("ControllerAdvice - " + threatResponse.body());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<String> entityNotFoundException (EntityNotFoundException exception) {
        LOGGER.error("Error: EntityNotFoundException - " + exception.getMessage());
        RestErrorMessage<String> threatResponse = new RestErrorMessage<>(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(threatResponse.httpStatus()).body("ControllerAdvice - " + threatResponse.body());
    }
}
