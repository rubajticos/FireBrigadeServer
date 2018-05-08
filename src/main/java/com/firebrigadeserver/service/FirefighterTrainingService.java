package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.entity.FirefighterTraining;
import com.firebrigadeserver.repositories.FirefighterTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<FirefighterTraining> addFirefighterTrainings(List<FirefighterTraining> firefighterTrainings) {
        return repository.save(firefighterTrainings);
    }

    @Override
    public List<FirefighterTraining>  updateFirefighterTrainings(List<FirefighterTraining> firefighterTraining) {
        Firefighter f = firefighterTraining.get(0).getFirefighter();
        List<FirefighterTraining> beforeUpdateTrainings = repository.findByFirefighter(f);
        List<FirefighterTraining> newTrainings = firefighterTraining;
        beforeUpdateTrainings.forEach(training -> {
            if (!newTrainings.contains(training)) {
                deleteFirefighterTraining(training.getIdFirefighterTraining());
            }
        });
        return repository.save(newTrainings);
    }

    @Override
    public void deleteFirefighterTraining(int firefighterTrainingId) {
        repository.delete(firefighterTrainingId);
    }
}
