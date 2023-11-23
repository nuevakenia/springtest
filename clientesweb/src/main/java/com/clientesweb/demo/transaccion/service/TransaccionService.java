package com.clientesweb.demo.transaccion.service;

import com.clientesweb.demo.transaccion.domain.entity.TransaccionEntity;
import com.clientesweb.demo.transaccion.rest.dtos.RequestSaveDTOTransaccion;
import com.clientesweb.demo.utils.Wrapper;
import com.clientesweb.demo.utils.exceptions.AppBadRequestException;
import com.clientesweb.demo.utils.exceptions.AppInternalServerErrorException;
import com.clientesweb.demo.utils.exceptions.AppNotFoundException;
import org.springframework.http.ResponseEntity;


public interface TransaccionService {
    public TransaccionEntity getById(Long id) throws AppInternalServerErrorException, AppNotFoundException;

    public ResponseEntity<Wrapper> findAll() throws AppNotFoundException, AppInternalServerErrorException;
    public ResponseEntity<Wrapper> findById(Long id) throws AppNotFoundException, AppInternalServerErrorException;
    public ResponseEntity<Wrapper> save(RequestSaveDTOTransaccion data) throws AppInternalServerErrorException, AppBadRequestException, AppNotFoundException;
    public ResponseEntity<Wrapper> update(Long idEditar, RequestSaveDTOTransaccion data) throws AppNotFoundException, AppInternalServerErrorException;
    public ResponseEntity<Wrapper> delete(Long id) throws AppNotFoundException, AppInternalServerErrorException;
}
