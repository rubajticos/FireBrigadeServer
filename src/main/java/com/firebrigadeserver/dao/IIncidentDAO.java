package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Incident;

import java.util.Date;
import java.util.List;

public interface IIncidentDAO {

    List<Incident> getAllIncidents();

    Incident getIncidentById(int incidentId);

    void addIncident(Incident incident);

    void updateIncident(Incident incident);

    void deleteIncident(int incidentId);

    boolean incidentExist(String type, Date date, String city, String description);

}
