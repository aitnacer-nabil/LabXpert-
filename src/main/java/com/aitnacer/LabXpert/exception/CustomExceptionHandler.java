package com.aitnacer.LabXpert.exception;

import com.aitnacer.LabXpert.dtos.ExceptionResponseDto;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.exception.utils.ApiExceptionParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {



    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionResponseDto>  handleApiExceptions(ApiException apiExceptionHandler){
        ExceptionResponseDto exceptionResponseDto = ApiExceptionParser.parseException(apiExceptionHandler);

        return ResponseEntity.status(exceptionResponseDto.getStatus())
                .body(exceptionResponseDto);
    }
}
