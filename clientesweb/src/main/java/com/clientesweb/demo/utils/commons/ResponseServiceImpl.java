package com.clientesweb.demo.utils.commons;

import com.clientesweb.demo.utils.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResponseServiceImpl implements  ResponseService{

    @Override
    public ResponseEntity<Wrapper> returnResponse(HttpStatus status, String message, boolean isOk, Object data) {
        Wrapper wrapper = new Wrapper();
        wrapper.setDescripcion(message);
        wrapper.setOK(isOk);
        wrapper.setData(data);
        return ResponseEntity.status(status).body(wrapper);
    }
}
