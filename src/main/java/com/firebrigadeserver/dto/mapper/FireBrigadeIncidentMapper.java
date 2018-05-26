package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.FireBrigadeIncidentDTO;
import com.firebrigadeserver.entity.FirebrigadeIncident;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FireBrigadeIncidentMapper implements Mapper<FirebrigadeIncident, FireBrigadeIncidentDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FirebrigadeIncident dtoToEntity(FireBrigadeIncidentDTO dto) {
        return modelMapper.map(dto, FirebrigadeIncident.class);
    }

    @Override
    public List<FirebrigadeIncident> dtoListToEntityList(List<FireBrigadeIncidentDTO> dtoList) {
        List<FirebrigadeIncident> entityList = new ArrayList<>();
        dtoList.forEach(fireBrigadeIncidentDTO -> entityList.add(dtoToEntity(fireBrigadeIncidentDTO)));
        return entityList;
    }

    @Override
    public FireBrigadeIncidentDTO entityToDto(FirebrigadeIncident entity) {
        return modelMapper.map(entity, FireBrigadeIncidentDTO.class);
    }

    @Override
    public List<FireBrigadeIncidentDTO> entityListToDtoList(List<FirebrigadeIncident> entityList) {
        List<FireBrigadeIncidentDTO> dtoList = new ArrayList<>();
        entityList.forEach(fireBrigadeIncident -> dtoList.add(entityToDto(fireBrigadeIncident)));
        return dtoList;
    }
}
