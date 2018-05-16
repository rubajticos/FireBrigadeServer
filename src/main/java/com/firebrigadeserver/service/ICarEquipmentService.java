package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.CarEquipment;

import java.util.List;

public interface ICarEquipmentService {

    List<CarEquipment> getAllCarEquipment();

    CarEquipment getCarEquipmentById(int carEquipmentId);

    List<CarEquipment> getActiveCarEquipmentForCar(int carId);

    CarEquipment getActiveCarEquipmentForEquipment(int equipmentId);

    List<CarEquipment> getWithdrawalCarEquipmentForCar(int carId);

    CarEquipment addCarEquipment(CarEquipment carEquipment);

    CarEquipment updateCarEquipment(CarEquipment carEquipment);

    void deleteCarEquipment(int carEquipmentId);


}
