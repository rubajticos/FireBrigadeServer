package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.CarEquipment;
import com.firebrigadeserver.repositories.CarEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarEquipmentService implements ICarEquipmentService {

    @Autowired
    private CarEquipmentRepository repository;

    @Autowired
    private CarService carService;

    @Override
    public List<CarEquipment> getAllCarEquipment() {
        return repository.findAll();
    }

    @Override
    public CarEquipment getCarEquipmentById(int carEquipmentId) {
        return repository.findOne(carEquipmentId);
    }

    @Override
    public List<CarEquipment> getActiveCarEquipmentForCar(int carId) {
        Car car = carService.getCarById(carId);
        return repository.findByCarAndDateOfWithDrawalIsNull(car);
    }

    @Override
    public List<CarEquipment> getWithdrawalCarEquipmentForCar(int carId) {
        Car car = carService.getCarById(carId);
        return repository.findByCarAndDateOfWithDrawalIsNotNull(car);
    }

    @Override
    public CarEquipment addCarEquipment(CarEquipment carEquipment) {
        if (!repository.existsByCarAndEquipmentAndQtyAndDateOfPutAndDateoOfWithDrawal(
                carEquipment.getCar(), carEquipment.getEquipment(), carEquipment.getQty(), carEquipment.getDateOfPut(), carEquipment.getDateOfWithdrawal())) {
            return repository.save(carEquipment);
        }

        return null;
    }

    @Override
    public CarEquipment updateCarEquipment(CarEquipment carEquipment) {
        CarEquipment updateCarEquipment = repository.findOne(carEquipment.getCarEquipmentId());
        updateCarEquipment.setQty(carEquipment.getQty());
        updateCarEquipment.setDateOfPut(carEquipment.getDateOfPut());
        updateCarEquipment.setDateOfWithdrawal(carEquipment.getDateOfWithdrawal());
        return repository.save(updateCarEquipment);
    }

    @Override
    public void deleteCarEquipment(int carEquipmentId) {
        repository.delete(carEquipmentId);
    }
}
