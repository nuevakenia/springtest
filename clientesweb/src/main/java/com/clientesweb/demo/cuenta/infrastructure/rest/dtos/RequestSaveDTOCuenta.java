package com.clientesweb.demo.cuenta.infrastructure.rest.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

import static com.clientesweb.demo.utils.Utils_Constants.*;

@Data
public class RequestSaveDTOCuenta {
    private Double saldoTotal;
    private String tipoCuenta;
    private Date fechaCreacion;
    private Date fechaVigencia;
    private Boolean estado;
    private Long idCuenta;
}
