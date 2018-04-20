package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.FirefighterTrainingDTO;
import com.firebrigadeserver.dto.mapper.FirefighterTrainingMapper;
import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.entity.FirefighterTraining;
import com.firebrigadeserver.service.FirefighterService;
import com.firebrigadeserver.service.IFirefighterTrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirefighterTrainingController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IFirefighterTrainingService firefighterTrainingService;

    @Autowired
    private FirefighterTrainingMapper firefighterTrainingMapper;

    @Autowired
    private FirefighterService firefighterService;

    @GetMapping("trainings/firefighter/{id}")
    public ResponseEntity getTrainingsForFirefighter(@PathVariable Integer id) {
        Firefighter firefighter = firefighterService.getFireFighterById(id);
        List<FirefighterTraining> listOfTrainings = firefighterTrainingService.getFireFighterTrainingByFirefighter(firefighter);
        List<FirefighterTrainingDTO> listofTrainingsDto = firefighterTrainingMapper.entityListToDtoList(listOfTrainings);
        if (listofTrainingsDto.size() != 0) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(listofTrainingsDto);
        }

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Brak wyszkolenia dla tego strażaka");
    }

    // TODO: 16/04/2018 Dodawanie i aktualizacja umiejetnosci
}
