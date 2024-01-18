package com.aitnacer.LabXpert.exception;

import com.aitnacer.LabXpert.dtos.ExceptionResponse;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.exception.utils.ApiExceptionParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleRuntimeExceptions(RuntimeException exception) {
        // Log data
        exception.printStackTrace();
        return handleApiExceptions(new InternalServerErrorException());
    }


    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionResponse>  handleApiExceptions(ApiException apiExceptionHandler){
        ExceptionResponse exceptionResponse = ApiExceptionParser.parseException(apiExceptionHandler);

        return ResponseEntity.status(exceptionResponse.getStatus())
                .body(exceptionResponse);
    }
}
