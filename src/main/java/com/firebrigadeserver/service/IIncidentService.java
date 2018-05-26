package com.firebrigadeserver.service;


import com.firebrigadeserver.dto.additional.CarsAndFirefighters;
import com.firebrigadeserver.dto.additional.IncidentFull;
import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.Incident;

import java.util.List;

public interface IIncidentService {

    List<Incident> getIncidentsByFireBrigade(FireBrigade fireBrigade);

    List<Incident> getIncidentsByCar(Car car);

    Incident getIncidentById(int incidentId);

    IncidentFull addIncident(IncidentFull incidentFull);

    Incident updateIncident(Incident incident);

    void deleteIncident(int incidentId);

    CarsAndFirefighters getDataForPreparingIncident(int fireBrigadeId);


}
