package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.CarIncidentDTO;
import com.firebrigadeserver.entity.CarIncident;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CarIncidentMapper implements Mapper<CarIncident, CarIncidentDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarIncident dtoToEntity(CarIncidentDTO dto) {
        return modelMapper.map(dto, CarIncident.class);
    }

    @Override
    public List<CarIncident> dtoListToEntityList(List<CarIncidentDTO> dtoList) {
        List<CarIncident> entityList = new ArrayList<>();
        dtoList.forEach(dto -> entityList.add(dtoToEntity(dto)));
        return entityList;
    }

    @Override
    public CarIncidentDTO entityToDto(CarIncident entity) {
        return modelMapper.map(entity, CarIncidentDTO.class);
    }

    @Override
    public List<CarIncidentDTO> entityListToDtoList(List<CarIncident> entityList) {
        List<CarIncidentDTO> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(entityToDto(entity)));
        return dtoList;
    }
}
