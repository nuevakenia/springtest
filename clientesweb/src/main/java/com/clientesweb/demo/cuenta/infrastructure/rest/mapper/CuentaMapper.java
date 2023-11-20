package com.clientesweb.demo.cuenta.infrastructure.rest.mapper;

import com.clientesweb.demo.cuenta.domain.entity.CuentaEntity;
import com.clientesweb.demo.cuenta.infrastructure.rest.dtos.RequestSaveDTOCuenta;
import com.clientesweb.demo.cuenta.infrastructure.rest.dtos.ResponseDTOCuenta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper {

    @Mapping(source="cliente", target="cliente" )
    ResponseDTOCuenta entityToDTO(CuentaEntity cuentasEntity);
    @Mapping(source="cliente", target="cliente.id" )
    CuentaEntity dtoToEntity(RequestSaveDTOCuenta cuentasDTO);
    List<ResponseDTOCuenta> entitiesToDtos(List<CuentaEntity> cuentasEntities);

    void updateEntity(RequestSaveDTOCuenta cuentasDto, @MappingTarget CuentaEntity cuentasEntity);
}
