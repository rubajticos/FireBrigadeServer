package com.firebrigadeserver.dto.mapper;

import com.firebrigadeserver.dto.FireBrigadeDTO;
import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.Firefighter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FireBrigadeMapper implements Mapper<FireBrigade, FireBrigadeDTO> {

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private FireBrigadeIncidentMapper fireBrigadeIncidentMapper = new FireBrigadeIncidentMapper();

    @Override
    public FireBrigade dtoToEntity(FireBrigadeDTO dto) {
        return null;
    }

    @Override
    public List<FireBrigade> dtoListToEntityList(List<FireBrigadeDTO> dtoList) {
        return null;
    }

    @Override
    public FireBrigadeDTO entityToDto(FireBrigade entity) {
        FireBrigadeDTO fireBrigadeDTO = modelMapper.map(entity, FireBrigadeDTO.class);
        fireBrigadeDTO.setFirefightersIds(firefighterListToIdsList(entity.getFirefighters()));
        fireBrigadeDTO.setCarsIds(carListToIdsList(entity.getCars()));
        fireBrigadeDTO.setEquipmentIds(equipmentListToIdsList(entity.getFireBrigadeEquipment()));
        fireBrigadeDTO.setIncidents(fireBrigadeIncidentMapper.entityListToDtoList(entity.getIncidents()));
        return fireBrigadeDTO;
    }

    private List<Integer> firefighterListToIdsList(List<Firefighter> firefighters) {
        List<Integer> firefightersIds = new ArrayList<>();
        for (Firefighter f : firefighters) {
            firefightersIds.add(f.getIdFirefighter());
        }
        return firefightersIds;
    }

    private List<Integer> carListToIdsList(List<Car> cars) {
        List<Integer> carsIds = new ArrayList<>();
        for (Car c : cars) {
            carsIds.add(c.getId());
        }
        return carsIds;
    }

    private List<Integer> equipmentListToIdsList(List<Equipment> equipment) {
        List<Integer> equipmentsIds = new ArrayList<>();
        for (Equipment e : equipment) {
            equipmentsIds.add(e.getId());
        }
        return equipmentsIds;
    }

    @Override
    public List<FireBrigadeDTO> entityListToDtoList(List<FireBrigade> entityList) {
        return null;
    }


}
