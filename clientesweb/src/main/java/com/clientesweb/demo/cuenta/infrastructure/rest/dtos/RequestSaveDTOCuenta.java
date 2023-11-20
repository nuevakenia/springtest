package com.clientesweb.demo.cuenta.infrastructure.rest.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

import static com.clientesweb.demo.utils.Utils_Constants.*;

@Data
public class RequestSaveDTOCuenta {
    private Double saldoTotal;

    @NotNull(message = "tipoCuenta" + ERROR_MSG_INCOMPLETO)
    private String tipoCuenta;

    @NotNull(message = "fechaCreacion" + ERROR_MSG_INCOMPLETO)
    private LocalDate fechaCreacion;

    @NotNull(message = "fechaVigencia" + ERROR_MSG_INCOMPLETO)
    private LocalDate fechaVigencia;

    @NotNull(message = "estado" + ERROR_MSG_INCOMPLETO)
    private Boolean estado;

    @NotNull(message = "cliente" + ERROR_MSG_INCOMPLETO)
    private Long cliente;
}
