package com.firebrigadeserver.controller;

import com.firebrigadeserver.entity.Training;
import com.firebrigadeserver.service.ITrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingController {

    @Autowired
    private ITrainingService trainingService;

    @GetMapping("trainings")
    public ResponseEntity<List<Training>> getAllTrainings() {
        List<Training> list = trainingService.getAllTrainings();
        return new ResponseEntity<List<Training>>(list, HttpStatus.OK);
    }
}
