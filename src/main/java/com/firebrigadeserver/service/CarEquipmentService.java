package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.CarEquipment;
import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.repositories.CarEquipmentRepository;
import com.firebrigadeserver.repositories.EquipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CarEquipmentService implements ICarEquipmentService {
    public final static String TAG = "CarEquipment Service";

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CarEquipmentRepository repository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private EquipmentService equipmentService;

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
        logger.debug(TAG, "pobieranie aktywnych sprzetow samochodu o id = " + carId);
        Car car = carService.getCarById(carId);
        return repository.findByCarAndDateOfWithdrawalIsNull(car);
    }

    @Override
    public CarEquipment getActiveCarEquipmentForEquipment(int equipmentId) {
        Equipment equipment = equipmentRepository.findOne(equipmentId);
        CarEquipment carEquipment = repository.findByEquipmentAndDateOfWithdrawalIsNull(equipment);
        return carEquipment;
    }

    @Override
    public List<CarEquipment> getWithdrawalCarEquipmentForCar(int carId) {
        Car car = carService.getCarById(carId);
        return repository.findByCarAndDateOfWithdrawalIsNotNull(car);
    }

    @Override
    public CarEquipment addCarEquipment(CarEquipment carEquipment) {
        if (!repository.existsByCarAndEquipmentAndQtyAndDateOfPutAndDateOfWithdrawal(
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

    @Override
    @Transactional
    public CarEquipment createEquipmentAndSetToCar(CarEquipment carEquipment) {
        Equipment candidateEquipment = carEquipment.getEquipment();
        Equipment createdEquipment = equipmentService.addEquipment(candidateEquipment);

        CarEquipment candidateCarEquipment = carEquipment;
        candidateCarEquipment.setEquipment(createdEquipment);


        return repository.save(candidateCarEquipment);
    }

    @Override
    public CarEquipment updateEquipmentAndUpdateCarSelection(CarEquipment carEquipment) {
        Equipment toUpdateEquipment = carEquipment.getEquipment();
        toUpdateEquipment = equipmentService.updateEquipment(toUpdateEquipment);

        CarEquipment toUpdateCarEquipment = carEquipment;
        toUpdateCarEquipment.setEquipment(toUpdateEquipment);

        CarEquipment previousCarEquipment = getActiveCarEquipmentForEquipment(toUpdateCarEquipment.getEquipment().getId());

        if (previousCarEquipment != null) {
            Car newCarCandidate = null;
            try {
                newCarCandidate = toUpdateCarEquipment.getCar();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            if (!Objects.equals(newCarCandidate, previousCarEquipment.getCar())) {
                takeEquipmentOutOfTheCar(previousCarEquipment);
                if (newCarCandidate != null) {
                    return setNewCarToEquipment(toUpdateEquipment, toUpdateCarEquipment);
                } else {
                    return previousCarEquipment;
                }
            }
        } else {
            if (toUpdateCarEquipment.getCar() != null) {
                return setNewCarToEquipment(toUpdateEquipment, toUpdateCarEquipment);
            }
        }

        return null;
    }

    private void takeEquipmentOutOfTheCar(CarEquipment previousCarEquipment) {
        previousCarEquipment.setDateOfWithdrawal(new Date());
        updateCarEquipment(previousCarEquipment);
    }

    private CarEquipment setNewCarToEquipment(Equipment toUpdateEquipment, CarEquipment toUpdateCarEquipment) {
        CarEquipment newCarEquipment = new CarEquipment();
        newCarEquipment.setEquipment(toUpdateEquipment);
        newCarEquipment.setCar(toUpdateCarEquipment.getCar());
        newCarEquipment.setQty(0);
        newCarEquipment.setDateOfPut(new Date());
        return addCarEquipment(newCarEquipment);
    }


}


