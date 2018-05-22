package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Integer> {

    List<Incident> findByFireBrigades_fireBrigade(FireBrigade fireBrigade);

    List<Incident> findByCars_car(Car car);

    List<Incident> findByDate(Date date);

    List<Incident> findByDateAfterAndDateBefore(Date after, Date before);

    boolean existsByTypeAndSubtypeAndDateAndCity(String type, String subtype, Date date, String city);

}
