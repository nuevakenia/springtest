package com.clientesweb.demo.transaccion.service.impl;

import com.clientesweb.demo.cuenta.domain.repository.CuentaRepository;
import com.clientesweb.demo.transaccion.domain.entity.TransaccionEntity;
import com.clientesweb.demo.transaccion.domain.repository.TransaccionRepository;
import com.clientesweb.demo.transaccion.rest.dtos.RequestSaveDTOTransaccion;
import com.clientesweb.demo.transaccion.rest.dtos.ResponseDTOTransaccion;
import com.clientesweb.demo.transaccion.rest.mapper.TransaccionMapper;
import com.clientesweb.demo.transaccion.service.TransaccionService;
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
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final TransaccionMapper transaccionMapper;
    private final ResponseService responseService;
    private final CuentaRepository cuentaRepository;

    public TransaccionServiceImpl(TransaccionRepository transaccionRepository, TransaccionMapper transaccionMapper, ResponseService responseService, CuentaRepository cuentaRepository) {
        this.transaccionRepository = transaccionRepository;
        this.transaccionMapper = transaccionMapper;
        this.responseService = responseService;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public TransaccionEntity getById(Long id) throws AppInternalServerErrorException, AppNotFoundException {
        try {
            return transaccionRepository.findById(id)
                    .orElseThrow(() -> new AppNotFoundException("No se encontro el transaccion con id: " + id));
        } catch (Exception e) {
            log.error("Ha ocurrido un error: " + e.getMessage());
            throw new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> findAll() throws AppNotFoundException, AppInternalServerErrorException {
        try {
            List<TransaccionEntity> entities = transaccionRepository.findAll();
            if (entities.isEmpty()) {
                throw new AppNotFoundException("No hay transacciones en la BD");
            }
            List<ResponseDTOTransaccion> responses = transaccionMapper.entitiesToDtos(entities);
            return responseService.returnResponse(HttpStatus.OK, "Exito En la operacion", true, responses);
        } catch (Exception e) {
            log.error("Ha ocurrido un error: " + e.getMessage());
            throw new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> findById(Long id) throws AppNotFoundException, AppInternalServerErrorException {
        try {
            TransaccionEntity entity = getById(id);
            ResponseDTOTransaccion response = transaccionMapper.entityToDTO(entity);
            return responseService.returnResponse(HttpStatus.OK, "Éxito en la operación", true, response);
        }catch (Exception e) {
            log.error("Ha Ocurrido un Error: " + e.getMessage());
            throw  new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> save(RequestSaveDTOTransaccion data) throws AppInternalServerErrorException, AppNotFoundException {
        List<TransaccionEntity> transacciones = transaccionRepository.findByCuentas(data.getCuentaEmisora(), data.getCuentaReceptora());
        if(transacciones.isEmpty()){
            throw new AppNotFoundException("Transaccion no encontrada");
        }
        try {
            TransaccionEntity entity = transaccionMapper.dtoToEntity(data);
            TransaccionEntity created = transaccionRepository.save(entity);
            ResponseDTOTransaccion response = transaccionMapper.entityToDTO(created);

            return responseService.returnResponse(HttpStatus.OK, "Éxito en la operación", true, response);
        }  catch (Exception e){
            log.error("Ha Ocurrido un Error: " + e.getMessage());
            throw  new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> update(Long idEditar, RequestSaveDTOTransaccion data) throws AppNotFoundException, AppInternalServerErrorException {
        try {
            TransaccionEntity entity = getById(idEditar);
            transaccionMapper.updateEntity(data, entity);
            TransaccionEntity updated = transaccionRepository.save(entity);
            ResponseDTOTransaccion response = transaccionMapper.entityToDTO(updated);

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
            transaccionRepository.deleteById(id);
            return responseService.returnResponse(HttpStatus.OK,"Registro eliminado", true, null);
        } catch (Exception e){
            log.error("Ha Ocurrido un Error: " + e.getMessage());
            throw  new AppInternalServerErrorException(e.getMessage());
        }
    }
}
