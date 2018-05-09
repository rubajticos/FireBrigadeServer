package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Car;

import java.util.List;

public interface ICarService {

    List<Car> getAllCars();

    List<Car> getCarsByFireBrigade(int fireBrigadeId);

    Car getCarById(int carId);

    Car addCar(Car car);

    Car updateCar(Car car);

    void deleteCar(int carId);
}
