package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.repositories.CarRepository;
import com.firebrigadeserver.repositories.FireBrigadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CarRepository repository;

    @Autowired
    private FireBrigadeRepository fireBrigadeRepository;


    @Override
    public List<Car> getAllCars() {
        return repository.findAll();
    }

    @Override
    public List<Car> getCarsByFireBrigade(int fireBrigadeId) {
        FireBrigade fireBrigade = fireBrigadeRepository.findByIdFireBrigade(fireBrigadeId);
        return repository.findByFireBrigade(fireBrigade);
    }

    @Override
    public Car getCarById(int carId) {
        return repository.findOne(carId);
    }

    @Override
    public Car addCar(Car car) {
        if (repository.existsByModelAndTypeAndOperationalNumbersAndPlates(car.getModel(), car.getType(), car.getOperationalNumbers(), car.getPlates())) {
            return null;
        } else {
            return repository.save(car);
        }
    }

    @Override
    public Car updateCar(Car car) {
        Car updateCar = repository.findById(car.getId());
        updateCar.setModel(car.getModel());
        updateCar.setOperationalNumbers(car.getOperationalNumbers());
        updateCar.setPlates(car.getPlates());
        updateCar.setWater(car.getWater());
        updateCar.setFoam(car.getFoam());
        updateCar.setMotorPumpPerformance(car.getMotorPumpPerformance());
        return repository.save(updateCar);
    }

    @Override
    public void deleteCar(int carId) {
        repository.delete(carId);
    }
}

