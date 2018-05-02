package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.TrainingDTO;
import com.firebrigadeserver.dto.mapper.TrainingMapper;
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

    @Autowired
    private TrainingMapper trainingMapper;

    @GetMapping("trainings")
    public ResponseEntity getAllTrainings() {
        List<Training> list = trainingService.getAllTrainings();
        List<TrainingDTO> dtoList = trainingMapper.entityListToDtoList(list);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoList);

    }
}
