package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CarDAO implements ICarDAO {
    private final Logger logger = LoggerFactory.getLogger(CarDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public CarDAO() {
    }


    @Override
    public List<Car> getAllCars() {
        try {
            String hql = "from Car as car order by car.id";
            logger.debug("Getting all cars now!");
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

    @Override
    public boolean carExist(String model, String plates) {
        String hql = "from car as car where model = :model and plates = :plates";
        int count = entityManager.createQuery(hql)
                .setParameter("model", model)
                .setParameter("plates", plates).getResultList().size();
        return count > 0 ? true : false;
    }
}
