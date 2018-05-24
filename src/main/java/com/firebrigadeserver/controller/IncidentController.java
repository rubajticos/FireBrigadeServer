package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.additional.CarsAndFirefighters;
import com.firebrigadeserver.entity.Incident;
import com.firebrigadeserver.service.IIncidentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IncidentController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IIncidentService incidentService;

    @GetMapping("incident/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Integer id) {
        Incident incident = incidentService.getIncidentById(id);
        return new ResponseEntity<Incident>(incident, HttpStatus.OK);
    }

    @RequestMapping(value = "incident", method = RequestMethod.POST)
    public ResponseEntity<Void> addIncident(@RequestBody Incident incident) {
        try {
            incidentService.addIncident(incident);
            log.debug("Poprawnie dodano zdarzenie");
        } catch (Exception e) {
            log.error("Blad przy dodawaniu zdarzenia", e.getMessage());
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "incident", method = RequestMethod.PUT)
    public ResponseEntity<Incident> updateIncident(@RequestBody Incident incident) {
        incidentService.updateIncident(incident);
        return new ResponseEntity<Incident>(incident, HttpStatus.OK);
    }

    @RequestMapping(value = "del/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer id) {
        incidentService.deleteIncident(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("incident/prepare/firebrigade/{fireBrigadeId}")
    public ResponseEntity getPreparedDataForIncident(@PathVariable Integer fireBrigadeId) {
        CarsAndFirefighters prepared = incidentService.getDataForPreparingIncident(fireBrigadeId);
        if (prepared != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(prepared);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }
}
