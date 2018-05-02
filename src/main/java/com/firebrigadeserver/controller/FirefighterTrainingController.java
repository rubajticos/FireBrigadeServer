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
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "firefighter/trainings", method = RequestMethod.POST)
    public ResponseEntity addFirefighterTrainings(@RequestBody List<FirefighterTrainingDTO> trainingsDTO) {
        List<FirefighterTrainingDTO> returnTrainings = null;
        try {
            List<FirefighterTraining> trainings = firefighterTrainingMapper.dtoListToEntityList(trainingsDTO);
            trainings = firefighterTrainingService.addFirefighterTrainings(trainings);
            if (trainings == null) {
                logger.debug("FirefighterTraining Controller", "Wystąpił błąd podczas dodawania szkoleń strażaka: ");
            } else {
                returnTrainings = trainingsDTO;
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(returnTrainings);
            }
        } catch (Exception e) {
            logger.debug("FirefighterTraining Controller", "Wystąpił błąd podczas dodawania szkoleń strażaka: " + e.getMessage());
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(returnTrainings);
    }

    // TODO: 02/05/2018 aktualizacja umiejetnosci

}
