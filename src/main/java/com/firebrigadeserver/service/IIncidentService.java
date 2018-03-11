package com.firebrigadeserver.service;


import com.firebrigadeserver.entity.Incident;

import java.util.List;

public interface IIncidentService {

    List<Incident> getAllIncidents();

    Incident getIncidentById(int incidentId);

    boolean addIncident(Incident incident);

    void updateIncident(Incident incident);

    void deleteIncident(int incidentId);


}
