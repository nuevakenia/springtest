package com.clientesweb.demo.cuenta.domain.entity;

import com.clientesweb.demo.clientes.domain.entity.ClientesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double saldoTotal;

    private String tipoCuenta;

    private LocalDate fechaCreacion;

    private LocalDate fechaVigencia;

    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClientesEntity cliente;

    // Getters y setters
}
