package com.ziumlight.common.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ziumlight.common.vo.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorResponse response = new ErrorResponse(new Date(), status.value(), status.getReasonPhrase(), status.getReasonPhrase(), request.getDescription(false));
        return handleExceptionInternal(ex, response, 
          new HttpHeaders(), status, request);
    }
}
