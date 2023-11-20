package com.clientesweb.demo.clientes.infrastructure.rest.mapper;

import com.clientesweb.demo.clientes.domain.entity.ClienteEntity;
import com.clientesweb.demo.clientes.infrastructure.rest.dtos.RequestSaveDTOCliente;
import com.clientesweb.demo.clientes.infrastructure.rest.dtos.ResponseDTOCliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientesMapper {
    List<ResponseDTOCliente> entitiesToDtos(List<ClienteEntity> clientesEntities);

    @Mapping(source = "cuentas", target = "idCuenta")
    ResponseDTOCliente entityToDTO(ClienteEntity clienteEntity);
    @Mapping(source = "idCuenta", target = "cuentas.id")
    ClienteEntity dtoToEntity(RequestSaveDTOCliente clientesDTO);

    void updateEntity(RequestSaveDTOCliente clientesDto, @MappingTarget ClienteEntity clienteEntity);
}
