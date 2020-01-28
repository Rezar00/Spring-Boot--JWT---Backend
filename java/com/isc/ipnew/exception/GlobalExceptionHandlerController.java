package com.isc.ipnew.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(WebRequest req, CustomException ex) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timestamp(new Date())
                .message(ex.getMessage())
                .details(req.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(WebRequest req, CustomException ex) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timestamp(new Date())
                .message(ex.getMessage())
                .details(req.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest req) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timestamp(new Date())
                .message(ex.getMessage())
                .details(req.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
