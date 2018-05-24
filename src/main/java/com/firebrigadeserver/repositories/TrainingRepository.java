package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainingRepository extends JpaRepository<Training, Integer> {

    Training findByIdTraining(int idTraining);

    Training findByName(String name);

}
