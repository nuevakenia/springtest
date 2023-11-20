package com.clientesweb.demo.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class AppBadRequestException extends AppGlobalException{

        public AppBadRequestException(String message) {
            super(HttpStatus.BAD_REQUEST.value(), message);
        }
}
