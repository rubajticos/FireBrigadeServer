package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.FirefighterTrainingDTO;
import com.firebrigadeserver.entity.FirefighterTraining;
import com.firebrigadeserver.service.FirefighterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FirefighterTrainingMapper implements Mapper<FirefighterTraining, FirefighterTrainingDTO> {

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private TrainingMapper trainingMapper;

    @Autowired
    FirefighterMapper firefighterMapper;

    @Autowired
    FirefighterService firefighterService;

    @Override
    public FirefighterTraining dtoToEntity(FirefighterTrainingDTO dto) {
        FirefighterTraining ft = modelMapper.map(dto, FirefighterTraining.class);
        return ft;
    }

    @Override
    public List<FirefighterTraining> dtoListToEntityList(List<FirefighterTrainingDTO> dtoList) {
        List<FirefighterTraining> entityList = new ArrayList<>();
        dtoList.forEach(firefighterTrainingDTO -> entityList.add(dtoToEntity(firefighterTrainingDTO)));
        return entityList;
    }

    @Override
    public FirefighterTrainingDTO entityToDto(FirefighterTraining entity) {
        FirefighterTrainingDTO ft = modelMapper.map(entity, FirefighterTrainingDTO.class);
        return ft;
    }

    @Override
    public List<FirefighterTrainingDTO> entityListToDtoList(List<FirefighterTraining> entityList) {
        List<FirefighterTrainingDTO> dtoList = new ArrayList<>();
        entityList.forEach(firefighterTraining -> dtoList.add(entityToDto(firefighterTraining)));
        return dtoList;
    }
}
