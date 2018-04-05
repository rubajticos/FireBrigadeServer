package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.FireBrigadeDTO;
import com.firebrigadeserver.entity.FireBrigade;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FireBrigadeMapper implements Mapper<FireBrigade, FireBrigadeDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FireBrigade dtoToEntity(FireBrigadeDTO dto) {
        ModelMapper myModelMapper = modelMapper;
        FireBrigade fireBrigade = myModelMapper.map(dto, FireBrigade.class);
        return fireBrigade;
    }

    @Override
    public List<FireBrigade> dtoListToEntityList(List<FireBrigadeDTO> dtoList) {
        List<FireBrigade> entities = new ArrayList<>();
        dtoList.forEach(dto -> entities.add(dtoToEntity(dto)));
        return entities;
    }

    @Override
    public FireBrigadeDTO entityToDto(FireBrigade entity) {
        FireBrigadeDTO fireBrigadeDTO = modelMapper.map(entity, FireBrigadeDTO.class);
        return fireBrigadeDTO;
    }

    @Override
    public List<FireBrigadeDTO> entityListToDtoList(List<FireBrigade> entityList) {
        List<FireBrigadeDTO> dtos = new ArrayList<>();
        entityList.forEach(entity -> dtos.add(entityToDto(entity)));
        return dtos;
    }


}
