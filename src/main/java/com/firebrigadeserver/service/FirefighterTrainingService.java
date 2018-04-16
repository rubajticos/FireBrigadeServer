package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.entity.FirefighterTraining;
import com.firebrigadeserver.repositories.FirefighterTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FirefighterTrainingService implements IFirefighterTrainingService {

    @Autowired
    private FirefighterTrainingRepository repository;

    @Override
    public List<FirefighterTraining> getAllFirefighterTrainings() {
        return repository.findAll();
    }

    @Override
    public FirefighterTraining getFireFighterTrainingById(int firefighterTrainingId) {
        return repository.findOne(firefighterTrainingId);
    }

    @Override
    public List<FirefighterTraining> getFireFighterTrainingByFirefighter(Firefighter firefighter) {
        return repository.findByFirefighter(firefighter);
    }

    @Override
    public FirefighterTraining addFirefighterTraining(FirefighterTraining firefighterTraining) {
        try {
            if (repository.existsByFirefighterAndTraining(firefighterTraining.getFirefighter(), firefighterTraining.getTraining())) {
                return null;
            } else {
                return repository.save(firefighterTraining);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public FirefighterTraining updateFirefighterTraining(FirefighterTraining firefighterTraining) {
        FirefighterTraining updateFirefighterTraining = repository.findOne(firefighterTraining.getIdFirefighterTraining());
        updateFirefighterTraining.setFirefighter(firefighterTraining.getFirefighter());
        updateFirefighterTraining.setTraining(firefighterTraining.getTraining());
        updateFirefighterTraining.setTrainigDate(firefighterTraining.getTrainigDate());
        return repository.save(updateFirefighterTraining);
    }

    @Override
    public void deleteFirefighterTraining(int firefighterTrainingId) {
        repository.delete(firefighterTrainingId);
    }
}
