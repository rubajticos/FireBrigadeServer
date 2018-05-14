package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.EquipmentDTO;
import com.firebrigadeserver.entity.Equipment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EquipmentMapper implements Mapper<Equipment, EquipmentDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Equipment dtoToEntity(EquipmentDTO dto) {
        Equipment equipment = modelMapper.map(dto, Equipment.class);
        return equipment;
    }

    @Override
    public List<Equipment> dtoListToEntityList(List<EquipmentDTO> dtoList) {
        List<Equipment> entityList = new ArrayList<>();
        dtoList.forEach(equipmentDTO -> entityList.add(dtoToEntity(equipmentDTO)));
        return entityList;
    }

    @Override
    public EquipmentDTO entityToDto(Equipment entity) {
        EquipmentDTO equipmentDTO = modelMapper.map(entity, EquipmentDTO.class);
        return equipmentDTO;
    }

    @Override
    public List<EquipmentDTO> entityListToDtoList(List<Equipment> entityList) {
        List<EquipmentDTO> dtoList = new ArrayList<>();
        entityList.forEach(equipment -> dtoList.add(entityToDto(equipment)));
        return dtoList;
    }
}
