package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Car;

import java.util.List;

public interface ICarService {

    List<Car> getAllCars();

    Car getCarById(int carId);

    boolean addCar(Car car);

    void updateCar(Car car);

    void deleteCar(int carId);
}
