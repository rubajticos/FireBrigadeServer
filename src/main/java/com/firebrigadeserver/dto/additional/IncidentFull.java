package com.firebrigadeserver.dto.additional;

import com.firebrigadeserver.entity.CarIncident;
import com.firebrigadeserver.entity.FirebrigadeIncident;
import com.firebrigadeserver.entity.Incident;

import java.util.List;

public class IncidentFull {

    private Incident incident;
    private List<CarIncident> cars;
    private List<FirebrigadeIncident> fireBrigades;

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public List<CarIncident> getCars() {
        return cars;
    }

    public void setCars(List<CarIncident> cars) {
        this.cars = cars;
    }

    public List<FirebrigadeIncident> getFireBrigades() {
        return fireBrigades;
    }

    public void setFireBrigades(List<FirebrigadeIncident> fireBrigades) {
        this.fireBrigades = fireBrigades;
    }
}
