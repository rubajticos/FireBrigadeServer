package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.FirefighterDTO;
import com.firebrigadeserver.entity.Firefighter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FirefighterMapper implements Mapper<Firefighter, FirefighterDTO> {

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private FirefighterTrainingMapper firefighterTrainingMapper;

    @Autowired
    private TrainingMapper trainingMapper;

    @Autowired
    private FireBrigadeMapper fireBrigadeMapper;

    @Override
    public Firefighter dtoToEntity(FirefighterDTO dto) {
        Firefighter firefighter = modelMapper.map(dto, Firefighter.class);
        return firefighter;
    }

    @Override
    public List<Firefighter> dtoListToEntityList(List<FirefighterDTO> dtoList) {
        List<Firefighter> entityList = new ArrayList<>();
        dtoList.forEach(firefighterDTO -> entityList.add(dtoToEntity(firefighterDTO)));
        return entityList;
    }

    @Override
    public FirefighterDTO entityToDto(Firefighter entity) {
        FirefighterDTO firefighterDTO = modelMapper.map(entity, FirefighterDTO.class);
        return firefighterDTO;
    }

    @Override
    public List<FirefighterDTO> entityListToDtoList(List<Firefighter> entityList) {
        List<FirefighterDTO> dtoList = new ArrayList<>();
        entityList.forEach(firefighter -> dtoList.add(entityToDto(firefighter)));
        return dtoList;
    }
}
