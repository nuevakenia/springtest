package com.clientesweb.demo.cuenta.infrastructure.rest.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseDTOCuenta {

    private Long id;
    private Double saldoTotal;
    private String tipoCuenta;
    private Date fechaCreacion;
    private Date fechaVigencia;
    private Boolean estado;

}
