package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.entity.FirefighterTraining;
import com.firebrigadeserver.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FirefighterTrainingRepository extends JpaRepository<FirefighterTraining, Integer> {

    List<FirefighterTraining> findByFirefighter(Firefighter firefighter);

    boolean existsByFirefighterAndTraining(Firefighter firefighter, Training training);
}
