package com.firebrigadeserver.service;

import com.firebrigadeserver.dao.ITrainingDAO;
import com.firebrigadeserver.entity.Training;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService implements ITrainingService {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ITrainingDAO trainingDAO;


    @Override
    public List<Training> getAllTrainings() {
        return trainingDAO.getAllTrainings();
    }
}
