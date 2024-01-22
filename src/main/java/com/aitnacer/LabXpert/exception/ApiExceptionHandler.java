package com.aitnacer.LabXpert.exception;

import com.aitnacer.LabXpert.exception.common.ApiException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class ApiExceptionHandler {

//TODO handle DefaultHandlerExceptionResolver
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleValidationException(ConstraintViolationException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("message","Validation error");
        errors.put("status", HttpStatus.BAD_REQUEST);
        errors.put("statusCode",HttpStatus.BAD_REQUEST.value()+"");
        Map<String, String> validationErrors = new HashMap<>();
        ex.getConstraintViolations().forEach((error) -> {

            validationErrors.put(String.valueOf(error.getPropertyPath()),error.getMessage());
        });

        errors.put("validationErrors", validationErrors);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, Object> errors = new HashMap<>();
        String fieldName = extractFieldName(ex.getMessage());
        errors.put("message", "Resource already exists");
        errors.put("field: ",fieldName);
        errors.put("status", HttpStatus.BAD_REQUEST);
        errors.put("statusCode", HttpStatus.BAD_REQUEST.value() + "");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    public String extractFieldName(String message) {
        Pattern pattern = Pattern.compile("key '(.*?)'");
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }

}
