package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.FirebrigadeIncident;
import com.firebrigadeserver.entity.Incident;
import com.firebrigadeserver.repositories.FireBrigadeIncidentRepository;

import javax.transaction.Transactional;
import java.util.List;

public class FireBrigadeIncidentService implements IFireBrigadeIncidentService {

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
