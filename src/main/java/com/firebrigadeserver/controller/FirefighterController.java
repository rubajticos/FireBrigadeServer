package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.FirefighterDTO;
import com.firebrigadeserver.dto.mapper.FireBrigadeMapper;
import com.firebrigadeserver.dto.mapper.FirefighterMapper;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.service.IFireBrigadeService;
import com.firebrigadeserver.service.IFirefighterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirefighterController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IFirefighterService firefighterService;

    @Autowired
    private IFireBrigadeService fireBrigadeService;

    @Autowired
    private FirefighterMapper firefighterMapper;

    @Autowired
    private FireBrigadeMapper fireBrigadeMapper;

    @GetMapping("firefighter/{id}")
    public ResponseEntity getFirefighterById(@PathVariable Integer id) {
        Firefighter firefighter = firefighterService.getFireFighterById(id);
        FirefighterDTO firefighterDTO = firefighterMapper.entityToDto(firefighter);
        logger.debug("ppp " + firefighterDTO.toString());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(firefighterDTO);
    }

    @GetMapping("firefighters")
    public ResponseEntity getAllFirefighters() {
        List<Firefighter> list = firefighterService.getAllFirefighters();
        List<FirefighterDTO> dtosList = firefighterMapper.entityListToDtoList(list);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtosList);
    }

    @GetMapping("firefighters/firebrigade/{firebrigadeId}")
    public ResponseEntity getAllFirefighters(@PathVariable Integer firebrigadeId) {
        List<Firefighter> list = firefighterService.getFirefightersByFirebrigade(firebrigadeId);
        List<FirefighterDTO> dtosList = firefighterMapper.entityListToDtoList(list);
        if (dtosList.size() != 0) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(dtosList);
        }

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Brak strażaków dla tej jednostki");

    }


    @RequestMapping(value = "firefighter/firebrigade/{firebrigadeId}", method = RequestMethod.POST)
    public ResponseEntity addFirefighter(@RequestBody FirefighterDTO firefighterDto, @PathVariable int firebrigadeId) {
        FirefighterDTO returnFirefighterDTO = null;
        try {
            FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(firebrigadeId);
            Firefighter firefighter = firefighterMapper.dtoToEntity(firefighterDto);
            firefighter.setFireBrigade(fireBrigade);
            firefighter = firefighterService.addFirefighter(firefighter);
            if (firefighter == null) {
                logger.debug("FirefighterController", "Wystąpił błąd podczas dodawania strażaka.");
            } else {
                returnFirefighterDTO = firefighterMapper.entityToDto(firefighter);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(returnFirefighterDTO);
            }
        } catch (Exception e) {
            logger.debug("FirefighterController", "Wystąpił błąd podczas dodawania strażaka. -  " + e.getMessage());

        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(returnFirefighterDTO);
    }

    @PutMapping("firefighter")
    public ResponseEntity updateFirefighter(@RequestBody FirefighterDTO firefighterDto) {
        Firefighter firefighter = firefighterMapper.dtoToEntity(firefighterDto);
        firefighter = firefighterService.updateFirefighter(firefighter);
        FirefighterDTO returnFirefighter = firefighterMapper.entityToDto(firefighter);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(returnFirefighter);
    }

    @RequestMapping(value = "firefighter/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFirefighter(@PathVariable Integer id) {
        firefighterService.deleteFirefighter(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
