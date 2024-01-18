package com.aitnacer.LabXpert.exception;

import com.aitnacer.LabXpert.exception.common.ApiException;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ApiException {

    public InternalServerErrorException() {
        super("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
