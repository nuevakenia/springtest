package com.clientesweb.demo.clientes.application.service;

import com.clientesweb.demo.clientes.domain.entity.ClienteEntity;
import com.clientesweb.demo.clientes.infrastructure.rest.dtos.RequestSaveDTOCliente;
import com.clientesweb.demo.exceptions.AppBadRequestException;
import com.clientesweb.demo.utils.Wrapper;
import com.clientesweb.demo.utils.exceptions.AppInternalServerErrorException;
import com.clientesweb.demo.utils.exceptions.AppNotFoundException;
import org.springframework.http.ResponseEntity;


public interface ClienteService {
    public ClienteEntity getById(Long idCliente) throws AppInternalServerErrorException, AppNotFoundException;

    public ResponseEntity<Wrapper> findAll() throws AppNotFoundException, AppInternalServerErrorException;
    public ResponseEntity<Wrapper> findById(Long id) throws AppNotFoundException, AppInternalServerErrorException;
    public ResponseEntity<Wrapper> save(RequestSaveDTOCliente data) throws AppInternalServerErrorException, AppBadRequestException;
    public ResponseEntity<Wrapper> update(Long idEditar, RequestSaveDTOCliente data) throws AppNotFoundException, AppInternalServerErrorException;
    public ResponseEntity<Wrapper> delete(Long id) throws AppNotFoundException, AppInternalServerErrorException;
}
