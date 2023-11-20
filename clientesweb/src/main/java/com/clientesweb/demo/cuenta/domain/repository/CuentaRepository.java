package com.clientesweb.demo.cuenta.domain.repository;

import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {
    @Query("SELECT e FROM CuentaEntity e WHERE e.id = ?1")
    Optional<CuentaEntity> findOneOptional(Long id);
}
