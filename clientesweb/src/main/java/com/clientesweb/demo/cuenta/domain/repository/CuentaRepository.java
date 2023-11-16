package com.clientesweb.demo.cuenta.domain.repository;

import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {
}
