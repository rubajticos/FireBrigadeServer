package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.entity.FirefighterTraining;

import java.util.List;

public interface IFirefighterTrainingService {

    List<FirefighterTraining> getAllFirefighterTrainings();

    FirefighterTraining getFireFighterTrainingById(int firefighterTrainingId);

    List<FirefighterTraining> getFireFighterTrainingByFirefighter(Firefighter firefighter);

    FirefighterTraining addFirefighterTraining(FirefighterTraining firefighterTraining);

    FirefighterTraining updateFirefighterTraining(FirefighterTraining firefighterTraining);

    void deleteFirefighterTraining(int firefighterTrainingId);

}
