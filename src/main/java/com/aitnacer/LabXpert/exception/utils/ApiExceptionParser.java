package com.aitnacer.LabXpert.exception.utils;

import com.aitnacer.LabXpert.dtos.ExceptionResponse;
import com.aitnacer.LabXpert.exception.common.ApiException;

import java.time.LocalDateTime;

public class ApiExceptionParser {
    public static ExceptionResponse parseException(ApiException apiException){
        return  ExceptionResponse.builder()
                .dateTime(LocalDateTime.now())
                .message(apiException.getMessage())
                .status(apiException.getStatus())
                .statusCode(apiException.getStatusCode())
                .build();
    }
}
