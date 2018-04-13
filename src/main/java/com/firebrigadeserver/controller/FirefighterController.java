package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.FirefighterDTO;
import com.firebrigadeserver.dto.mapper.FirefighterMapper;
import com.firebrigadeserver.entity.Firefighter;
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
    private FirefighterMapper firefighterMapper;

    @GetMapping("firefighter/{id}")
    public ResponseEntity getFirefighterByid(@PathVariable Integer id) {
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

    @RequestMapping(value = "firefighter", method = RequestMethod.POST)
    public ResponseEntity<Void> addFirefighter(@RequestBody Firefighter firefighter) {
        try {
            firefighterService.addFirefighter(firefighter);
        } catch (Exception e) {
            logger.error("Blad przy dodawaniu strazaka(controller)", e.getMessage());
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("firefighter")
    public ResponseEntity<Firefighter> updateFirefighter(@RequestBody Firefighter firefighter) {
        firefighterService.updateFirefighter(firefighter);
        return new ResponseEntity<Firefighter>(firefighter, HttpStatus.OK);
    }

    @RequestMapping(value = "firefighter/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFirefighter(@PathVariable Integer id) {
        firefighterService.deleteFirefighter(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
