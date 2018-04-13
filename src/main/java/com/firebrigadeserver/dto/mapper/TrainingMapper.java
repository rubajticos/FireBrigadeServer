package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.TrainingDTO;
import com.firebrigadeserver.entity.Training;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TrainingMapper implements Mapper<Training, TrainingDTO> {

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Training dtoToEntity(TrainingDTO dto) {
        Training training = modelMapper.map(dto, Training.class);
        return training;
    }

    @Override
    public List<Training> dtoListToEntityList(List<TrainingDTO> dtoList) {
        List<Training> entityList = new ArrayList<>();
        dtoList.forEach(trainingDTO -> entityList.add(dtoToEntity(trainingDTO)));
        return entityList;
    }

    @Override
    public TrainingDTO entityToDto(Training entity) {
        return modelMapper.map(entity, TrainingDTO.class);
    }

    @Override
    public List<TrainingDTO> entityListToDtoList(List<Training> entityList) {
        List<TrainingDTO> dtoList = new ArrayList<>();
        entityList.forEach(training -> dtoList.add(entityToDto(training)));
        return dtoList;
    }
}
