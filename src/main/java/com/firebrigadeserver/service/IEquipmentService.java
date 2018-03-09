package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Equipment;

import java.util.List;

public interface IEquipmentService {

    List<Equipment> getAllEquipment();

    Equipment getEquipmentById(int equipmentId);

    boolean addEquipment(Equipment equipment);

    void updateEquipment(Equipment equipment);

    void deleteEquipment(int eqiupmentId);


}
