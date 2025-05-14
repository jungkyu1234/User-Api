package com.zerobase.cms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({
            CustomerException.class
    })
    public ResponseEntity<ExceptionResponse> customRequestException(final CustomerException c) {
        System.out.println("api Exception : {}" + c.getErrorCode());
        return ResponseEntity.badRequest().body(new ExceptionResponse(c.getMessage(),c.getErrorCode().getHttpStatus()));
    }

    @Getter
    @ToString
    @AllArgsConstructor
    public static class ExceptionResponse{
        private String message;
        private HttpStatus httpStatus;
    }
}
