package com.firebrigadeserver.controller;

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
@RequestMapping("firefighter")
public class FirefighterController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IFirefighterService firefighterService;

    @GetMapping("firefighter/{id}")
    public ResponseEntity<Firefighter> getFirefighterByid(@PathVariable Integer id) {
        Firefighter firefighter = firefighterService.getFireFighterById(id);
        return new ResponseEntity<Firefighter>(firefighter, HttpStatus.OK);
    }

    @GetMapping("firefighters")
    public ResponseEntity<List<Firefighter>> getAllFirefighters() {
        List<Firefighter> list = firefighterService.getAllFirefighters();
        return new ResponseEntity<List<Firefighter>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
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

    @RequestMapping(value = "del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFirefighter(@PathVariable Integer id) {
        firefighterService.deleteFirefighter(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
