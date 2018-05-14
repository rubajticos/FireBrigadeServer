package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService implements IEquipmentService {

    @Autowired
    private EquipmentRepository repository;

    @Autowired
    private FireBrigadeService fireBrigadeService;

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
}
