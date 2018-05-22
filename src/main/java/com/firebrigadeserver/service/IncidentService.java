package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.*;
import com.firebrigadeserver.repositories.IncidentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IncidentService implements IIncidentService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private FireBrigadeIncidentService fireBrigadeIncidentService;


    @Override
    @Transactional
    public List<Incident> getIncidentsByFireBrigade(FireBrigade fireBrigade) {
        return incidentRepository.findByFireBrigades_fireBrigade(fireBrigade);
    }

    @Override
    @Transactional
    public List<Incident> getIncidentsByCar(Car car) {
        return incidentRepository.findByCars_car(car);
    }

    @Override
    @Transactional
    public Incident getIncidentById(int incidentId) {
        return incidentRepository.findOne(incidentId);
    }

    @Override
    @Transactional
    public Incident addIncident(Incident incident) {
        if (!incidentRepository.existsByTypeAndSubtypeAndDateAndCity(incident.getType(), incident.getSubtype(), incident.getDate(), incident.getCity())) {
            List<FirebrigadeIncident> firebrigadeIncidents = incident.getFireBrigades();
            firebrigadeIncidents = fireBrigadeIncidentService.addFireBrigadeIncident(firebrigadeIncidents);

            List<CarIncident> carIncidents = incident.getCars();
//            carIncidents = carIncidentService.addCarIncident(carIncidents); todo odkomentowac

            Incident incidentToCreate = incident;
            incidentToCreate.setFireBrigades(firebrigadeIncidents);
            incidentToCreate.setCars(carIncidents);

            return incidentRepository.save(incidentToCreate);

        }

        return null;
    }

    @Override
    @Transactional
    public Incident updateIncident(Incident incident) {
        // TODO: 22/05/2018 aktualizacja zdarzenia
        return null;
    }

    @Override
    @Transactional
    public void deleteIncident(int incidentId) {
        // TODO: 22/05/2018 usuwanie zdarzenia
    }
}
