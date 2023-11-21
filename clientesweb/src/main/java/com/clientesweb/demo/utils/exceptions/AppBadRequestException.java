package com.clientesweb.demo.utils.exceptions;

import com.clientesweb.demo.utils.exceptions.AppGlobalException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class AppBadRequestException extends AppGlobalException {

        public AppBadRequestException(String message) {
            super(HttpStatus.BAD_REQUEST.value(), message);
        }
}
