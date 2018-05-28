package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.additional.CarsAndFirefighters;
import com.firebrigadeserver.dto.additional.IncidentFull;
import com.firebrigadeserver.dto.additional.IncidentFullDTO;
import com.firebrigadeserver.dto.mapper.IncidentFullMapper;
import com.firebrigadeserver.dto.mapper.IncidentMapper;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.FirebrigadeIncident;
import com.firebrigadeserver.entity.Incident;
import com.firebrigadeserver.service.IFireBrigadeService;
import com.firebrigadeserver.service.IIncidentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncidentController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IIncidentService incidentService;

    @Autowired
    private IFireBrigadeService fireBrigadeService;

    @Autowired
    private IncidentMapper incidentMapper;

    @Autowired
    private IncidentFullMapper incidentFullMapper;

    @GetMapping("incident/{id}")
    public ResponseEntity getIncidentById(@PathVariable Integer id) {
        IncidentFull incident = incidentService.getIncidentById(id);

        if (incident != null) {
            IncidentFullDTO incidentDTO = incidentFullMapper.entityToDto(incident);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(incidentDTO);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);

    }

    @GetMapping("incident/firebrigade/{id}")
    public ResponseEntity getIncidentsByFirebrigade(@PathVariable Integer id) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(id);
        List<IncidentFull> incidentFulls = incidentService.getIncidentsByFireBrigade(fireBrigade);
        if (incidentFulls.size() > 0) {
            List<IncidentFullDTO> incidentFullDTOS = incidentFullMapper.entityListToDtoList(incidentFulls);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(incidentFullDTOS);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @RequestMapping(value = "incident/firebrigade/{fireBrigadeId}", method = RequestMethod.POST)
    public ResponseEntity addIncident(@RequestBody IncidentFullDTO incident, @PathVariable int fireBrigadeId) {
        IncidentFull incidentFull = incidentFullMapper.dtoToEntity(incident);
        incidentFull.setFireBrigades(makeFireBrigadeIncident(incidentFull.getFireBrigades(), fireBrigadeId));
        incidentFull = incidentService.addIncident(incidentFull);

        if (incident != null) {
            IncidentFullDTO incidentFullDTO = incidentFullMapper.entityToDto(incidentFull);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(incidentFullDTO);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);

    }

    private List<FirebrigadeIncident> makeFireBrigadeIncident(List<FirebrigadeIncident> fireBrigades, int fireBrigadeId) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(fireBrigadeId);
        List<FirebrigadeIncident> withFireBrigade = fireBrigades;
        for (FirebrigadeIncident f : withFireBrigade) {
            f.setFireBrigade(fireBrigade);
        }
        return withFireBrigade;
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
