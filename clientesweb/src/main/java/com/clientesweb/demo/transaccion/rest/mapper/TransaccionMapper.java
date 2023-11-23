package com.clientesweb.demo.transaccion.rest.mapper;

import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import com.clientesweb.demo.cuenta.infrastructure.rest.dtos.RequestSaveDTOCuenta;
import com.clientesweb.demo.cuenta.infrastructure.rest.dtos.ResponseDTOCuenta;
import com.clientesweb.demo.transaccion.domain.entity.TransaccionEntity;
import com.clientesweb.demo.transaccion.rest.dtos.RequestSaveDTOTransaccion;
import com.clientesweb.demo.transaccion.rest.dtos.ResponseDTOTransaccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransaccionMapper {

    @Mapping(target = "cuentaEmisora", source = "cuenta.id")
    @Mapping(target = "cuentaReceptora", source = "cuenta.id")
    ResponseDTOTransaccion entityToDTO(TransaccionEntity transaccionEntity);

    @Mapping(target = "cuenta.id", source = "cuentaEmisora")
    @Mapping(target = "cuenta.id", source = "cuentaReceptora")
    TransaccionEntity dtoToEntity(RequestSaveDTOTransaccion transaccionDTO);

    List<ResponseDTOTransaccion> entitiesToDtos(List<TransaccionEntity> transaccionesEntities);

    void updateEntity(RequestSaveDTOTransaccion transaccionDto, @MappingTarget TransaccionEntity transaccionesEntity);


}
