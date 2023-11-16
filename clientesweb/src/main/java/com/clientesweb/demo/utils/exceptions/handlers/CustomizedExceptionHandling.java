package com.clientesweb.demo.utils.exceptions.handlers;


import com.clientesweb.demo.utils.Wrapper;
import com.clientesweb.demo.utils.commons.ResponseService;
import com.clientesweb.demo.utils.exceptions.AppInternalServerErrorException;
import com.clientesweb.demo.utils.exceptions.AppNotFoundException;
import com.clientesweb.demo.utils.exceptions.ExceptionResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Log4j2
@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    private final ResponseService responseService;

    public CustomizedExceptionHandling(ResponseService responseService) {
        this.responseService = responseService;
    }

    @ExceptionHandler(AppInternalServerErrorException.class)
    protected ResponseEntity<Wrapper> handleInternalServerErrorException(AppInternalServerErrorException ex) {
        log.error("[Error] - Internal Server Error handler..."+ex.getMessage());
        ExceptionResponse response = new ExceptionResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setErrorMessage(ex.getMessage());
        return responseService.returnResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error",false,response);
    }

    @ExceptionHandler(AppNotFoundException.class)
    protected ResponseEntity<Wrapper> handleNotFoundException(AppNotFoundException ex) {
        log.error("[Error] - AppNotFoundException handler... "+ex.getMessage());
        ExceptionResponse response = new ExceptionResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setErrorMessage(ex.getMessage());
        return responseService.returnResponse(HttpStatus.NOT_FOUND, ex.getMessage(),false,response);
    }
}
