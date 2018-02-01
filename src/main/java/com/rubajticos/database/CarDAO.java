package com.rubajticos.database;

import com.rubajticos.database.interfaces.InterfaceCarDAO;
import com.rubajticos.model.Car;

import java.util.HashSet;

public class CarDAO implements InterfaceCarDAO {

    public CarDAO() {
    }

    @Override
    public int insertCar(String model, String operationalNumbers, String plates, String type, int water, int fireBrigadeId) {
        return 0;
    }

    @Override
    public boolean updateCar(int id, String model, String operationalNumbers, String plates, String type, int water, int fireBrigadeId) {
        return false;
    }

    @Override
    public boolean deleteCar(int id) {
        return false;
    }

    @Override
    public Car selectCar(int id) {
        return null;
    }

    @Override
    public HashSet<Car> selectCars(int fireBrigadeId) {
        return null;
    }

    @Override
    public HashSet<Integer> selectIdCars(int fireBrigadeId) {
        return null;
    }
}
