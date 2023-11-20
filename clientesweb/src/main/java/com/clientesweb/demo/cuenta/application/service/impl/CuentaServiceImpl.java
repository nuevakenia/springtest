package com.clientesweb.demo.cuenta.application.service.impl;

import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import com.clientesweb.demo.cuenta.domain.repository.CuentaRepository;
import com.clientesweb.demo.cuenta.infrastructure.rest.dtos.RequestSaveDTOCuenta;
import com.clientesweb.demo.cuenta.infrastructure.rest.dtos.ResponseDTOCuenta;
import com.clientesweb.demo.cuenta.infrastructure.rest.mapper.CuentaMapper;
import com.clientesweb.demo.cuenta.application.service.CuentaService;
import com.clientesweb.demo.utils.Wrapper;
import com.clientesweb.demo.utils.commons.ResponseService;
import com.clientesweb.demo.utils.exceptions.AppInternalServerErrorException;
import com.clientesweb.demo.utils.exceptions.AppNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final CuentaMapper cuentaMapper;
    private final ResponseService responseService;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, CuentaMapper cuentaMapper, ResponseService responseService) {
        this.cuentaRepository = cuentaRepository;
        this.cuentaMapper = cuentaMapper;
        this.responseService = responseService;
    }

    @Override
    public CuentaEntity getById(Long idCuenta) throws AppInternalServerErrorException, AppNotFoundException {
        try {
            return cuentaRepository.findById(idCuenta)
                    .orElseThrow(() -> new AppNotFoundException("No se encontro el cuenta con id: " + idCuenta));
        } catch (Exception e) {
            log.error("Ha ocurrido un error: " + e.getMessage());
            throw new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> findAll() throws AppNotFoundException, AppInternalServerErrorException {
        try {
            List<CuentaEntity> entities = cuentaRepository.findAll();
            if (entities.isEmpty()) {
                throw new AppNotFoundException("No hay cuenta en la BD");
            }
            List<ResponseDTOCuenta> responses = cuentaMapper.entitiesToDtos(entities);
            return responseService.returnResponse(HttpStatus.OK, "Exito En la operacion", true, responses);
        } catch (Exception e) {
            log.error("Ha ocurrido un error: " + e.getMessage());
            throw new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> findById(Long id) throws AppNotFoundException, AppInternalServerErrorException {
        try {
            CuentaEntity entity = getById(id);
            ResponseDTOCuenta response = cuentaMapper.entityToDTO(entity);
            return responseService.returnResponse(HttpStatus.OK, "Éxito en la operación", true, response);
        }catch (Exception e) {
            log.error("Ha Ocurrido un Error: " + e.getMessage());
            throw  new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> save(RequestSaveDTOCuenta data) throws AppInternalServerErrorException {
        data.setEstado(false);
        LocalDate var1 = data.getFechaCreacion().minusYears(1).minusMonths(3).minusDays(1);
        // data.setFechaCreacion(var1);
        log.error("SKEREEE " + data.getFechaCreacion().toString());
        try {
            CuentaEntity entity = cuentaMapper.dtoToEntity(data);
            CuentaEntity created = cuentaRepository.save(entity);
            ResponseDTOCuenta response = cuentaMapper.entityToDTO(created);

            return responseService.returnResponse(HttpStatus.OK, "Éxito en la operación", true, response);
        }  catch (Exception e){
            log.error("Ha Ocurrido un Error: " + e.getMessage());
            throw  new AppInternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Wrapper> update(Long idEditar, RequestSaveDTOCuenta data) throws AppNotFoundException, AppInternalServerErrorException {
        try {
            CuentaEntity entity = getById(idEditar);
            cuentaMapper.updateEntity(data, entity);
            CuentaEntity updated = cuentaRepository.save(entity);
            ResponseDTOCuenta response = cuentaMapper.entityToDTO(updated);

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
            cuentaRepository.deleteById(id);
            return responseService.returnResponse(HttpStatus.OK,"Registro eliminado", true, null);
        } catch (Exception e){
            log.error("Ha Ocurrido un Error: " + e.getMessage());
            throw  new AppInternalServerErrorException(e.getMessage());
        }
    }
}
