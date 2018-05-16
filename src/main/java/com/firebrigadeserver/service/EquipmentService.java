package com.firebrigadeserver.service;

import com.firebrigadeserver.dto.additional.EquipmentAdditional;
import com.firebrigadeserver.entity.CarEquipment;
import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService implements IEquipmentService {

    @Autowired
    private EquipmentRepository repository;

    @Autowired
    private FireBrigadeService fireBrigadeService;

    @Autowired
    private CarEquipmentService carEquipmentService;

    @Override
    public List<Equipment> getAllEquipment() {
        return repository.findAll();
    }

    @Override
    public List<Equipment> getEquipmentsByFireBrigade(int fireBrigadeId) {
        FireBrigade fb = fireBrigadeService.getFireBrigadeById(fireBrigadeId);
        return repository.findByFireBrigade(fb);
    }

    @Override
    public Equipment getEquipmentById(int equipmentId) {
        return repository.findOne(equipmentId);
    }

    @Override
    public Equipment addEquipment(Equipment equipment) {
        try {
            if (!repository.existsByNameAndType(equipment.getName(), equipment.getType())) {
                return repository.save(equipment);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        Equipment updateEquipment = repository.findOne(equipment.getId());
        updateEquipment.setName(equipment.getName());
        updateEquipment.setType(equipment.getType());
        return repository.save(updateEquipment);
    }

    @Override
    public void deleteEquipment(int eqiupmentId) {
        repository.delete(eqiupmentId);
    }

    @Override
    public List<EquipmentAdditional> getActiveEquipmentsByFireBrigadeWithCarNames(int fireBrigadeId) {
        List<Equipment> equipmentList = getEquipmentsByFireBrigade(fireBrigadeId);
        List<EquipmentAdditional> equipmentAdditionalList = new ArrayList<>();
        for (Equipment eq : equipmentList) {
            CarEquipment carEquipment = carEquipmentService.getActiveCarEquipmentForEquipment(eq.getId());
            if (carEquipment != null) {
                EquipmentAdditional equipmentAdditional = new EquipmentAdditional();
                equipmentAdditional.setId(carEquipment.getEquipment().getId());
                equipmentAdditional.setName(carEquipment.getEquipment().getName());
                equipmentAdditional.setType(carEquipment.getEquipment().getType());
                equipmentAdditional.setCarName(carEquipment.getCar().getModel());
                equipmentAdditionalList.add(equipmentAdditional);
            } else {
                EquipmentAdditional equipmentAdditional = new EquipmentAdditional();
                equipmentAdditional.setId(eq.getId());
                equipmentAdditional.setName(eq.getName());
                equipmentAdditional.setType(eq.getType());
                equipmentAdditional.setCarName(null);
                equipmentAdditionalList.add(equipmentAdditional);
            }
        }

        return equipmentAdditionalList;
    }
}
