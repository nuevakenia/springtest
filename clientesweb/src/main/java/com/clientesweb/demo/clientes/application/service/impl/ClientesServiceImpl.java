package com.clientesweb.demo.clientes.application.service.impl;

import com.clientesweb.demo.clientes.application.service.ClienteService;
import com.clientesweb.demo.clientes.domain.entity.ClienteEntity;
import com.clientesweb.demo.clientes.domain.repository.ClientesRepository;
import com.clientesweb.demo.clientes.infrastructure.rest.dtos.RequestSaveDTOCliente;
import com.clientesweb.demo.clientes.infrastructure.rest.dtos.ResponseDTOCliente;
import com.clientesweb.demo.clientes.infrastructure.rest.mapper.ClientesMapper;
import com.clientesweb.demo.cuenta.domain.repository.CuentaRepository;
import com.clientesweb.demo.utils.exceptions.AppBadRequestException;
import com.clientesweb.demo.utils.Wrapper;
import com.clientesweb.demo.utils.commons.ResponseService;
import com.clientesweb.demo.utils.exceptions.AppInternalServerErrorException;
import com.clientesweb.demo.utils.exceptions.AppNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class ClientesServiceImpl implements ClienteService {

    private final ClientesRepository clientesRepository;
    private final ClientesMapper clientesMapper;
    private final ResponseService responseService;
    private final CuentaRepository cuentaRepository;

    public ClientesServiceImpl(ClientesRepository clientesRepository, ClientesMapper clientesMapper, ResponseService responseService, CuentaRepository cuentaRepository) {
        this.clientesRepository = clientesRepository;
        this.clientesMapper = clientesMapper;
        this.responseService = responseService;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public ClienteEntity getById(Long idCliente) throws AppInternalServerErrorException, AppNotFoundException {
        try {
            return clientesRepository.findById(idCliente)
                    .orElseThrow(() -> new AppNotFoundException("No se encontro el cliente con id: " + idCliente));
        } catch (Exception e) {
            log.error("Ha ocurrido un error: " + e.getMessage());
            throw new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> findAll() throws AppNotFoundException, AppInternalServerErrorException {
        try {
            List<ClienteEntity> entities = clientesRepository.findAll();
            if (entities.isEmpty()) {
                throw new AppNotFoundException("No hay clientes en la BD");
            }
            List<ResponseDTOCliente> responses = clientesMapper.entitiesToDtos(entities);
            return responseService.returnResponse(HttpStatus.OK, "Exito En la operacion", true, responses);
        } catch (Exception e) {
            log.error("Ha ocurrido un error: " + e.getMessage());
            throw new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> findById(Long id) throws AppNotFoundException, AppInternalServerErrorException {
        try {
            ClienteEntity entity = getById(id);
            ResponseDTOCliente response = clientesMapper.entityToDTO(entity);
            return responseService.returnResponse(HttpStatus.OK, "Éxito en la operación", true, response);
        }catch (Exception e) {
            log.error("Ha Ocurrido un Error: " + e.getMessage());
            throw  new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> save(RequestSaveDTOCliente data) throws AppInternalServerErrorException, AppNotFoundException {

        cuentaRepository.findOneOptional(data.getIdCuenta())
                .orElseThrow(() -> new AppNotFoundException("Cuenta no encontrada."));

        try {
            ClienteEntity entity = clientesMapper.dtoToEntity(data);
            ClienteEntity created = clientesRepository.save(entity);
            ResponseDTOCliente response = clientesMapper.entityToDTO(created);

            return responseService.returnResponse(HttpStatus.OK, "Éxito en la operación", true, response);
        }  catch (Exception e){
            log.error("Ha Ocurrido un Error: " + e.getMessage());
            throw  new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> update(Long idEditar, RequestSaveDTOCliente data) throws AppNotFoundException, AppInternalServerErrorException {
        try {
            ClienteEntity entity = getById(idEditar);
            clientesMapper.updateEntity(data, entity);
            ClienteEntity updated = clientesRepository.save(entity);
            ResponseDTOCliente response = clientesMapper.entityToDTO(updated);

            return responseService.returnResponse(HttpStatus.OK, "Éxito en la operación", true, response);
        } catch (Exception e){
            log.error("Ha Ocurrido un Error: " + e.getMessage());
            throw  new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> delete(Long id) throws AppNotFoundException, AppInternalServerErrorException {
        try {
            getById(id);
            clientesRepository.deleteById(id);
            return responseService.returnResponse(HttpStatus.OK,"Registro eliminado", true, null);
        } catch (Exception e){
            log.error("Ha Ocurrido un Error: " + e.getMessage());
            throw  new AppInternalServerErrorException(e.getMessage());
        }
    }
}
