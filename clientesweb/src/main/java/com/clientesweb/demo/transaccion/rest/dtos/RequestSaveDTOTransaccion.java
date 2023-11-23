package com.clientesweb.demo.transaccion.rest.dtos;


import lombok.Data;

@Data
public class RequestSaveDTOTransaccion {
    private Long id;
    private String tipo;
    private Double monto;
    private Long cuentaEmisora;
    private Long cuentaReceptora;
}
