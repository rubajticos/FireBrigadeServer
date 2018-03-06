package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Car;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CarDAO implements ICarDAO {
    final static Logger logger = Logger.getLogger(UserDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public CarDAO() {
    }


    @Override
    public List<Car> getAllCars() {
        try {
            String hql = "from Car as car order by car.id";
            return (List<Car>) entityManager.createQuery(hql).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Car getCarById(int carId) {
        return entityManager.find(Car.class, carId);
    }

    @Override
    public void addCar(Car car) {
        entityManager.persist(car);
    }

    @Override
    public void updateCar(Car car) {
        Car updateCar = getCarById(car.getId());
        updateCar.setModel(car.getModel());
        updateCar.setOperationalNumbers(car.getOperationalNumbers());
        updateCar.setPlates(car.getPlates());
        updateCar.setType(car.getType());
        updateCar.setWater(car.getWater());
        updateCar.setFoam(car.getFoam());
        updateCar.setMotorPumpPerformance(car.getMotorPumpPerformance());
        updateCar.setFireBrigade(car.getFireBrigade());
        entityManager.flush();
    }

    @Override
    public void deleteCar(int carId) {
        entityManager.remove(getCarById(carId));
    }
}
