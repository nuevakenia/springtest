package com.clientesweb.demo.cuenta.infrastructure.rest.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

import static com.clientesweb.demo.utils.Utils_Constants.*;

@Data
public class RequestSaveDTOCuenta {
    private Long idCuenta;
    private Double saldoTotal;
    private String tipoCuenta;
    private LocalDate fechaCreacion;
    private LocalDate fechaVigencia;
    private Boolean estado;
    private Long clienteId;
}
