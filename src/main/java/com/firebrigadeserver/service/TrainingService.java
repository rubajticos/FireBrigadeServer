package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Training;
import com.firebrigadeserver.repositories.TrainingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService implements ITrainingService {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public Training getTrainingByName(String trainingName) {
        return trainingRepository.findByName(trainingName);
    }
}
