package com.clientesweb.demo.clientes.domain.entity;

import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaCreacion;

    //relaciones
    @OneToMany( mappedBy =  "clientes", fetch = FetchType.LAZY) // mapeado como clientes en  CuentaEntity
    private List<CuentaEntity> cuentas;
}
