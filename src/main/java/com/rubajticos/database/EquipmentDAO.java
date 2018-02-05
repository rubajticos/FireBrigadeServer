package com.rubajticos.database;

import com.rubajticos.database.interfaces.InterfaceEquipmentDAO;

public class EquipmentDAO implements InterfaceEquipmentDAO {

    @Override
    public boolean insertEquipment(String name, String type) {
        return false;
    }

    @Override
    public boolean updateEquipment(int id, String name, String type) {
        return false;
    }

    @Override
    public boolean deleteEquipment(int id) {
        return false;
    }

    @Override
    public boolean selectEquipment(int id) {
        return false;
    }

    @Override
    public boolean selectEquipment(String name) {
        return false;
    }
}
