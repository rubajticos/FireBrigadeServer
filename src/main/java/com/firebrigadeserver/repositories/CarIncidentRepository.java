package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.CarIncident;
import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarIncidentRepository extends JpaRepository<CarIncident, Integer> {

    boolean existsByCarAndIncidentAndDriverAndCommander(Car car, Incident incident, Firefighter driver, Firefighter commander);

    List<CarIncident> findByIncident(Incident incident);

}
