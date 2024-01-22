package com.aitnacer.LabXpert.exception;

import com.aitnacer.LabXpert.dtos.ExceptionResponse;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.exception.utils.ApiExceptionParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {



    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionResponse>  handleApiExceptions(ApiException apiExceptionHandler){
        ExceptionResponse exceptionResponse = ApiExceptionParser.parseException(apiExceptionHandler);

        return ResponseEntity.status(exceptionResponse.getStatus())
                .body(exceptionResponse);
    }
}
