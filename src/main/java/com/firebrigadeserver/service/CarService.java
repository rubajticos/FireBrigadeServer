package com.firebrigadeserver.service;

import com.firebrigadeserver.dao.ICarDAO;
import com.firebrigadeserver.entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICarDAO carDAO;


    @Override
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Override
    public Car getCarById(int carId) {
        return carDAO.getCarById(carId);
    }

    @Override
    public boolean addCar(Car car) {
        if (carDAO.carExist(car.getModel(), car.getPlates())) {
            return false;
        } else {
            carDAO.addCar(car);
            return true;
        }
    }

    @Override
    public void updateCar(Car car) {
        carDAO.updateCar(car);
    }

    @Override
    public void deleteCar(int carId) {
        carDAO.deleteCar(carId);
    }
}

