package com.clientesweb.demo.clientes.domain.repository;

import com.clientesweb.demo.clientes.domain.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<ClienteEntity, Long> {
}
