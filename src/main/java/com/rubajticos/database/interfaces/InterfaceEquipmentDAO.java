package com.rubajticos.database.interfaces;

public interface InterfaceEquipmentDAO {

    boolean insertEquipment(String name, String type);

    boolean updateEquipment(int id, String name, String type);

    boolean deleteEquipment(int id);

    boolean selectEquipment(int id);

    boolean selectEquipment(String name);


}
