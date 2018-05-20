package com.firebrigadeserver.dto.additional;

import com.firebrigadeserver.dto.CarDTO;
import com.firebrigadeserver.dto.CarEquipmentDTO;
import lombok.Data;

import java.util.List;

@Data
public class CarEquipmentWithAllCars {

    private CarEquipmentDTO carEquipment;
    private List<CarDTO> allCars;
}
