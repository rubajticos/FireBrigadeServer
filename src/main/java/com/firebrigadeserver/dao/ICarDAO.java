package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Car;

import java.util.List;

public interface ICarDAO {

    List<Car> getAllCars();

    Car getCarById(int carId);

    void addCar(Car car);

    void updateCar(Car car);

    void deleteCar(int carId);

}
