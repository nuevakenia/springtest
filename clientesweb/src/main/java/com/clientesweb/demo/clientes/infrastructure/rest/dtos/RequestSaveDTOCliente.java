package com.clientesweb.demo.clientes.infrastructure.rest.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import static com.clientesweb.demo.utils.Utils_Constants.*;

@Data
public class RequestSaveDTOCliente {
    private String nombre;
    private String apellido;
    private String email;
    private Long idCuenta;
}
