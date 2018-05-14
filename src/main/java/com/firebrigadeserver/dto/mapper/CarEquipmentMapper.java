package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.CarEquipmentDTO;
import com.firebrigadeserver.entity.CarEquipment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CarEquipmentMapper implements Mapper<CarEquipment, CarEquipmentDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarEquipment dtoToEntity(CarEquipmentDTO dto) {
        CarEquipment carEquipment = modelMapper.map(dto, CarEquipment.class);
        return carEquipment;
    }

    @Override
    public List<CarEquipment> dtoListToEntityList(List<CarEquipmentDTO> dtoList) {
        List<CarEquipment> entityList = new ArrayList<>();
        dtoList.forEach(carEquipmentDTO -> entityList.add(dtoToEntity(carEquipmentDTO)));
        return entityList;
    }

    @Override
    public CarEquipmentDTO entityToDto(CarEquipment entity) {
        CarEquipmentDTO ft = modelMapper.map(entity, CarEquipmentDTO.class);
        return ft;
    }

    @Override
    public List<CarEquipmentDTO> entityListToDtoList(List<CarEquipment> entityList) {
        List<CarEquipmentDTO> dtoList = new ArrayList<>();
        entityList.forEach(carEquipment -> dtoList.add(entityToDto(carEquipment)));
        return dtoList;
    }
}
