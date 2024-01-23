package com.aitnacer.LabXpert.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDto {
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateTime;
    private HttpStatus status;
    private Integer statusCode;
}
