package com.firebrigadeserver.service;

import com.firebrigadeserver.dao.IEquipmentDAO;
import com.firebrigadeserver.entity.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService implements IEquipmentService {

    @Autowired
    private IEquipmentDAO equipmentDAO;

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentDAO.getAllEquipment();
    }

    @Override
    public Equipment getEquipmentById(int equipmentId) {
        return equipmentDAO.getEquipmentById(equipmentId);
    }

    @Override
    public boolean addEquipment(Equipment equipment) {
        if (equipmentDAO.equipmentExist(equipment.getName(), equipment.getType(), equipment.getFireBrigade())) {
            return false;
        } else {
            equipmentDAO.addEquipment(equipment);
            return true;
        }
    }

    @Override
    public void updateEquipment(Equipment equipment) {
        equipmentDAO.updateEquipment(equipment);
    }

    @Override
    public void deleteEquipment(int eqiupmentId) {
        equipmentDAO.deleteEquipment(eqiupmentId);
    }
}
