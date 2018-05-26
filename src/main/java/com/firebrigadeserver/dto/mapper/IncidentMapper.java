package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.IncidentDTO;
import com.firebrigadeserver.entity.Incident;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class IncidentMapper implements Mapper<Incident, IncidentDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Incident dtoToEntity(IncidentDTO dto) {
        return modelMapper.map(dto, Incident.class);
    }

    @Override
    public List<Incident> dtoListToEntityList(List<IncidentDTO> dtoList) {
        List<Incident> entityList = new ArrayList<>();
        dtoList.forEach(incidentDTO -> entityList.add(dtoToEntity(incidentDTO)));
        return entityList;
    }

    @Override
    public IncidentDTO entityToDto(Incident entity) {
        return modelMapper.map(entity, IncidentDTO.class);
    }

    @Override
    public List<IncidentDTO> entityListToDtoList(List<Incident> entityList) {
        List<IncidentDTO> dtoList = new ArrayList<>();
        entityList.forEach(incident -> dtoList.add(entityToDto(incident)));
        return dtoList;
    }
}
