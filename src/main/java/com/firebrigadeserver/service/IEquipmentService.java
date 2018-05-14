package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Equipment;

import java.util.List;

public interface IEquipmentService {

    List<Equipment> getAllEquipment();

    List<Equipment> getEquipmentsByFireBrigade(int fireBrigadeId);

    Equipment getEquipmentById(int equipmentId);

    Equipment addEquipment(Equipment equipment);

    Equipment updateEquipment(Equipment equipment);

    void deleteEquipment(int eqiupmentId);


}
