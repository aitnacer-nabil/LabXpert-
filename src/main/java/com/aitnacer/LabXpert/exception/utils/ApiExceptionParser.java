package com.aitnacer.LabXpert.exception.utils;

import com.aitnacer.LabXpert.dtos.ExceptionResponseDto;
import com.aitnacer.LabXpert.exception.common.ApiException;

import java.time.LocalDateTime;

public class ApiExceptionParser {
    public static ExceptionResponseDto parseException(ApiException apiException){
        return  ExceptionResponseDto.builder()
                .dateTime(LocalDateTime.now())
                .message(apiException.getMessage())
                .status(apiException.getStatus())
                .statusCode(apiException.getStatusCode())
                .build();
    }
}
