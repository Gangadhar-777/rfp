package com.my3tech.rfp.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.my3tech.rfp.dto.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleRFPNotFoundException(NotFoundException exc, WebRequest req) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO
                .builder()
                .apiPath(req.getDescription(false))
                .errorCode(HttpStatus.NOT_FOUND)
                .errorMessage("RFP Not found")
                .errorTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception exc, WebRequest req) {
        exc.printStackTrace();
        return new ResponseEntity<>(
                ErrorResponseDTO
                        .builder()
                        .apiPath(req.getDescription(false))
                        .errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
                        .errorMessage("Internal Server Error! Please Try Again!")
                        .errorTime(LocalDateTime.now())
                        .build(),

                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
