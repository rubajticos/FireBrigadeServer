package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.entity.FirefighterTraining;

import java.util.List;

public interface IFirefighterTrainingService {

    List<FirefighterTraining> getAllFirefighterTrainings();

    FirefighterTraining getFireFighterTrainingById(int firefighterTrainingId);

    List<FirefighterTraining> getFireFighterTrainingByFirefighter(Firefighter firefighter);

    List<FirefighterTraining> addFirefighterTrainings(List<FirefighterTraining> firefighterTrainings);

    List<FirefighterTraining> updateFirefighterTrainings(List<FirefighterTraining> firefighterTraining);

    void deleteFirefighterTraining(int firefighterTrainingId);

}
