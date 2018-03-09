package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.entity.FireBrigade;

import java.util.List;

public interface IEquipmentDAO {

    List<Equipment> getAllEquipment();

    Equipment getEquipmentById(int equipmentId);

    void addEquipment(Equipment equipment);

    void updateEquipment(Equipment equipment);

    void deleteEquipment(int equipmentId);

    boolean equipmentExist(String name, String type, FireBrigade fireBrigade);


}
