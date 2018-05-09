package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.FireBrigade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findById(int id);

    Car findByFireBrigadeAndPlates(FireBrigade fireBrigade, String plates);

    List<Car> findByFireBrigade(FireBrigade fireBrigade);

    boolean existsByModelAndTypeAndOperationalNumbersAndPlates(String model, String type, String operationalNumbers, String plates);
}
