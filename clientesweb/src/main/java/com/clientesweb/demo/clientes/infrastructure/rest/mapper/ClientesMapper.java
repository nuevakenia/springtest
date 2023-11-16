package com.clientesweb.demo.clientes.infrastructure.rest.mapper;

import com.clientesweb.demo.clientes.domain.entity.ClientesEntity;
import com.clientesweb.demo.clientes.infrastructure.rest.dtos.RequestSaveDTO;
import com.clientesweb.demo.clientes.infrastructure.rest.dtos.ResponseDTOClientes;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientesMapper {
    ResponseDTOClientes entityToDTO(ClientesEntity clientesEntity);
    ClientesEntity dtoToEntity(RequestSaveDTO clientesDTO);
    List<ResponseDTOClientes> entitiesToDtos(List<ClientesEntity> clientesEntities);

    void updateEntity(RequestSaveDTO clientesDto, @MappingTarget ClientesEntity clientesEntity);
}
