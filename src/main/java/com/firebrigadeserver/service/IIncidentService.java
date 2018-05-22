package com.firebrigadeserver.service;


import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.Incident;

import java.util.List;

public interface IIncidentService {

    List<Incident> getIncidentsByFireBrigade(FireBrigade fireBrigade);

    List<Incident> getIncidentsByCar(Car car);

    Incident getIncidentById(int incidentId);

    Incident addIncident(Incident incident);

    Incident updateIncident(Incident incident);

    void deleteIncident(int incidentId);


}
