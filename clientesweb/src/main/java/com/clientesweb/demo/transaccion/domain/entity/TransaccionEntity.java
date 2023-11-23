package com.clientesweb.demo.transaccion.domain.entity;

import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Double monto;
    private LocalDateTime timestamp;

    //relaciones
    @ManyToOne
    @JoinColumn(name = "cuentaEmisoraId", referencedColumnName = "id")
    private CuentaEntity cuentaEmisora;

    @ManyToOne
    @JoinColumn(name = "cuentaReceptoraId",referencedColumnName = "id")
    private CuentaEntity cuentaReceptora;
}

