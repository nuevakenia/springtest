package com.clientesweb.demo.cuenta.infrastructure.rest.mapper;

import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import com.clientesweb.demo.cuenta.infrastructure.rest.dtos.RequestSaveDTOCuenta;
import com.clientesweb.demo.cuenta.infrastructure.rest.dtos.ResponseDTOCuenta;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper {
    ResponseDTOCuenta entityToDTO(CuentaEntity cuentasEntity);
    CuentaEntity dtoToEntity(RequestSaveDTOCuenta cuentasDTO);
    List<ResponseDTOCuenta> entitiesToDtos(List<CuentaEntity> cuentasEntities);

    void updateEntity(RequestSaveDTOCuenta cuentasDto, @MappingTarget CuentaEntity cuentasEntity);
}
