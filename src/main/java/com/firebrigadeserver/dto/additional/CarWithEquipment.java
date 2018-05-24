package com.firebrigadeserver.dto.additional;

import com.firebrigadeserver.dto.CarDTO;
import com.firebrigadeserver.dto.EquipmentDTO;

import java.util.List;

public class CarWithEquipment {

    CarDTO car;
    List<EquipmentDTO> equipments;

    public CarDTO getCar() {
        return car;
    }

    public void setCarDTO(CarDTO car) {
        this.car = car;
    }

    public List<EquipmentDTO> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<EquipmentDTO> equipments) {
        this.equipments = equipments;
    }
}
