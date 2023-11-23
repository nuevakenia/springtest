package com.clientesweb.demo.transaccion.domain.repository;

import com.clientesweb.demo.transaccion.domain.entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransaccionRepository extends JpaRepository<TransaccionEntity, Long> {

    @Query("SELECT t FROM TransaccionEntity t WHERE t.cuentaEmisora.id = :cuentaEmisoraId AND t.cuentaReceptora.id = :cuentaReceptoraId")
    List<TransaccionEntity> findByCuentas(@Param("cuentaEmisoraId") Long cuentaEmisoraId, @Param("cuentaReceptoraId") Long cuentaReceptoraId);
}