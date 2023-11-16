package com.clientesweb.demo.cuenta.infrastructure.rest.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

import static com.clientesweb.demo.utils.Utils_Constants.*;

@Data
public class RequestSaveDTO {
    @NotNull(message = "saldoTotal" + ERROR_MSG_INCOMPLETO)
    private Double saldoTotal;

    @NotNull(message = "tipoCuenta" + ERROR_MSG_INCOMPLETO)
    private String tipoCuenta;

    @NotNull(message = "fechaCreacion" + ERROR_MSG_INCOMPLETO)
    private Date fechaCreacion;

    @NotNull(message = "fechaVigencia" + ERROR_MSG_INCOMPLETO)
    private Date fechaVigencia;

    @NotNull(message = "estado" + ERROR_MSG_INCOMPLETO)
    private Boolean estado;
}
