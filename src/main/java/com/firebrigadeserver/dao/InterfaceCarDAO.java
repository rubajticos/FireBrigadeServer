package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Car;

import java.util.HashSet;

public interface InterfaceCarDAO {

    int insertCar(String model, String operationalNumbers, String plates, String type, int water, int fireBrigadeId);

    boolean updateCar(int id, String model, String operationalNumbers, String plates, String type, int water, int fireBrigadeId);

    boolean deleteCar(int id);

    Car selectCar(int id);

    HashSet<Car> selectCars(int fireBrigadeId);

    HashSet<Integer> selectIdCars(int fireBrigadeId);


}
