package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.FirebrigadeIncident;
import com.firebrigadeserver.entity.Incident;
import com.firebrigadeserver.repositories.FireBrigadeIncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FireBrigadeIncidentService implements IFireBrigadeIncidentService {

    @Autowired
    private FireBrigadeIncidentRepository fireBrigadeIncidentRepository;


    @Override
    public FirebrigadeIncident getOneFireBrigadeIncident(int fireBrigadeIncidentId) {
        return null;
    }

    @Override
    @Transactional
    public List<FirebrigadeIncident> getFireBrigadeIncidentsForFireBrigade(FireBrigade fireBrigade) {
        return fireBrigadeIncidentRepository.findByFireBrigade(fireBrigade);
    }

    @Override
    @Transactional
    public List<FirebrigadeIncident> getFireBrigadeIncidentsForIncident(Incident incident) {
        return fireBrigadeIncidentRepository.findByIncident(incident);
    }

    @Override
    @Transactional
    public FirebrigadeIncident addFireBrigadeIncident(FirebrigadeIncident firebrigadeIncident) {
        if (!fireBrigadeIncidentRepository.existsByIncidentAndFireBrigade(firebrigadeIncident.getIncident(), firebrigadeIncident.getFireBrigade())) {
            return fireBrigadeIncidentRepository.save(firebrigadeIncident);
        }

        return null;
    }

    @Override
    public List<FirebrigadeIncident> addFireBrigadeIncident(List<FirebrigadeIncident> firebrigadeIncidents) {
        for (FirebrigadeIncident f : firebrigadeIncidents) {
            if (fireBrigadeIncidentRepository.existsByIncidentAndFireBrigade(f.getIncident(), f.getFireBrigade()))
                return null;
        }

        return fireBrigadeIncidentRepository.save(firebrigadeIncidents);
    }

    @Override
    @Transactional
    public FirebrigadeIncident updateFireBrigadeIncident(FirebrigadeIncident firebrigadeIncident) {
        FirebrigadeIncident toUpdate = fireBrigadeIncidentRepository.findOne(firebrigadeIncident.getIdFirebrigadeIncident());
        toUpdate.setDateTimeOfAlarm(firebrigadeIncident.getDateTimeOfAlarm());
        return fireBrigadeIncidentRepository.save(toUpdate);
    }

    @Override
    @Transactional
    public void deleteFireBrigadeIncident(int firebrigadeIncidentId) {
        fireBrigadeIncidentRepository.delete(firebrigadeIncidentId);
    }
}
