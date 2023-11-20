package com.clientesweb.demo.cuenta.infrastructure.rest.dtos;

import com.clientesweb.demo.clientes.domain.entity.ClientesEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ResponseDTOCuenta {

    private Long id;
    private Double saldoTotal;
    private String tipoCuenta;
    private LocalDate fechaCreacion;
    private LocalDate fechaVigencia;
    private Boolean estado;
    private Long cliente;

}
