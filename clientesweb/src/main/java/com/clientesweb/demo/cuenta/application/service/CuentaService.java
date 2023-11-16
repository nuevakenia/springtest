package com.clientesweb.demo.cuenta.application.service;

import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import com.clientesweb.demo.cuenta.infrastructure.rest.dtos.RequestSaveDTO;
import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import com.clientesweb.demo.utils.Wrapper;
import com.clientesweb.demo.utils.exceptions.AppInternalServerErrorException;
import com.clientesweb.demo.utils.exceptions.AppNotFoundException;
import org.springframework.http.ResponseEntity;


public interface CuentaService {
    public CuentaEntity getById(Long idCuenta) throws AppInternalServerErrorException, AppNotFoundException;

    public ResponseEntity<Wrapper> findAll() throws AppNotFoundException, AppInternalServerErrorException;
    public ResponseEntity<Wrapper> findById(Long id) throws AppNotFoundException, AppInternalServerErrorException;
    public ResponseEntity<Wrapper> save(RequestSaveDTO data) throws AppInternalServerErrorException;
    public ResponseEntity<Wrapper> update(Long idEditar, RequestSaveDTO data) throws AppNotFoundException, AppInternalServerErrorException;
    public ResponseEntity<Wrapper> delete(Long id) throws AppNotFoundException, AppInternalServerErrorException;
}
