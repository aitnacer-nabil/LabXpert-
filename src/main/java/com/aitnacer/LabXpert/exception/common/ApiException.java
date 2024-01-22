package com.aitnacer.LabXpert.exception.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

@Getter
public class ApiException extends  RuntimeException implements Supplier<ApiException> {

    private final HttpStatus status;
    private final Integer statusCode;

    public ApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;

        this.statusCode = status.value();
    }

    public ApiException(String message,long id) {
        super( message +String.format(" Id : %s",id));
        this.status = HttpStatus.BAD_REQUEST;

        this.statusCode = status.value();
    }
    public ApiException(String message) {
        super( message);
        this.status = HttpStatus.BAD_REQUEST;

        this.statusCode = status.value();
    }
    @Override
    public ApiException get() {
        return this;
    }
}
