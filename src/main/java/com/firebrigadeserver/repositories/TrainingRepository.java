package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.Training;

public interface TrainingRepository {

    Training findByIdTraining(int idTraining);

}
