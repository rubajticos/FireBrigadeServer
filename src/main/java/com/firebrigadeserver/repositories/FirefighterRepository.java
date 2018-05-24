package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FirefighterRepository extends JpaRepository<Firefighter, Integer> {

    Firefighter findByIdFirefighter(int id);

    Firefighter findByFireBrigadeAndNameAndLastName(FireBrigade fireBrigade, String name, String lastname);

    List<Firefighter> findByFireBrigade(FireBrigade fireBrigade);

    boolean existsByNameAndLastNameAndBirthday(String name, String lastname, Date birthday);

    List<Firefighter> findByTrainings_training(Training training);

}
