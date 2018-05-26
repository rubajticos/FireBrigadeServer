package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.additional.IncidentFull;
import com.firebrigadeserver.dto.additional.IncidentFullDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class IncidentFullMapper implements Mapper<IncidentFull, IncidentFullDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public IncidentFull dtoToEntity(IncidentFullDTO dto) {
        return modelMapper.map(dto, IncidentFull.class);
    }

    @Override
    public List<IncidentFull> dtoListToEntityList(List<IncidentFullDTO> dtoList) {
        List<IncidentFull> entityList = new ArrayList<>();
        dtoList.forEach(d -> entityList.add(dtoToEntity(d)));
        return entityList;
    }

    @Override
    public IncidentFullDTO entityToDto(IncidentFull entity) {
        return modelMapper.map(entity, IncidentFullDTO.class);
    }

    @Override
    public List<IncidentFullDTO> entityListToDtoList(List<IncidentFull> entityList) {
        List<IncidentFullDTO> dtoList = new ArrayList<>();
        entityList.forEach(e -> dtoList.add(entityToDto(e)));
        return dtoList;
    }
}
