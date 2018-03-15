package com.firebrigadeserver.dto.mapper;

public interface Mapper<E, D> {

    E DtoToEntity(D dto);

    D EntityToDto(E entity);
}
