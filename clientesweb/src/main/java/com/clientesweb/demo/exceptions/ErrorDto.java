package com.clientesweb.demo.exceptions;

import lombok.Data;

@Data
public class ErrorDto {

    private String name;
    private String value;

    public ErrorDto(String name,  String value) {
        this.name = name;
        this.value = value;
    }
}
