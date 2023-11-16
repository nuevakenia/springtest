package com.clientesweb.demo.clientes.infrastructure.rest.dtos;

import lombok.Data;

@Data
public class ResponseDTOClientes {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
}
