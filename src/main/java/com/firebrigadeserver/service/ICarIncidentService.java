package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.CarIncident;
import com.firebrigadeserver.entity.Incident;

import java.util.List;

public interface ICarIncidentService {

    CarIncident getCarIncidentById(int carIncidentId);

    CarIncident addCarIncident(CarIncident carIncident);

    List<CarIncident> addCarIncident(List<CarIncident> carIncidents);

    List<CarIncident> getCarIncidentByIncident(Incident incident);

    CarIncident updateCarIncident(CarIncident carIncident);

    void deleteCarIncident(int carIncidentId);


}
