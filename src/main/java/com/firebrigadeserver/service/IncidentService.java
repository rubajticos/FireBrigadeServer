package com.firebrigadeserver.service;

import com.firebrigadeserver.dao.IIncidentDAO;
import com.firebrigadeserver.entity.Incident;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService implements IIncidentService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IIncidentDAO incidentDAO;


    @Override
    public List<Incident> getAllIncidents() {
        return incidentDAO.getAllIncidents();
    }

    @Override
    public Incident getIncidentById(int incidentId) {
        return incidentDAO.getIncidentById(incidentId);
    }

    @Override
    public boolean addIncident(Incident incident) {
        if (incidentDAO.incidentExist(incident.getType(), incident.getDate(), incident.getCity(), incident.getDescription())) {
            return false;
        } else {
            incidentDAO.addIncident(incident);
            return true;
        }
    }

    @Override
    public void updateIncident(Incident incident) {
        incidentDAO.updateIncident(incident);
    }

    @Override
    public void deleteIncident(int incidentId) {
        incidentDAO.deleteIncident(incidentId);
    }
}
