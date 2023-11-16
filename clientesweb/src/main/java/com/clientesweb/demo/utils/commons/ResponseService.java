package com.clientesweb.demo.utils.commons;

import com.clientesweb.demo.utils.Wrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ResponseService {

    public ResponseEntity<Wrapper> returnResponse(HttpStatus status, String message, boolean isOk, Object data);
}
