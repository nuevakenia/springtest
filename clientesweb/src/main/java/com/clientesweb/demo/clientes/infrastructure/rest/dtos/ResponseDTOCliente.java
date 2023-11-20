package com.clientesweb.demo.clientes.infrastructure.rest.dtos;

import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import lombok.Data;

@Data
public class ResponseDTOCliente {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private CuentaEntity idCuenta;
}
