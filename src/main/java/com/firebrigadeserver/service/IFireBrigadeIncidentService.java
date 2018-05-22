package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.FirebrigadeIncident;
import com.firebrigadeserver.entity.Incident;

import java.util.List;

public interface IFireBrigadeIncidentService {

    FirebrigadeIncident getOneFireBrigadeIncident(int fireBrigadeIncidentId);

    List<FirebrigadeIncident> getFireBrigadeIncidentsForFireBrigade(FireBrigade fireBrigade);

    List<FirebrigadeIncident> getFireBrigadeIncidentsForIncident(Incident incident);

    FirebrigadeIncident addFireBrigadeIncident(FirebrigadeIncident firebrigadeIncident);

    List<FirebrigadeIncident> addFireBrigadeIncident(List<FirebrigadeIncident> firebrigadeIncidents);

    FirebrigadeIncident updateFireBrigadeIncident(FirebrigadeIncident firebrigadeIncident);

    void deleteFireBrigadeIncident(int firebrigadeIncidentId);

}
