package com.firebrigadeserver.dto.additional;

import com.firebrigadeserver.dto.CarIncidentDTO;
import com.firebrigadeserver.dto.FireBrigadeIncidentDTO;
import com.firebrigadeserver.dto.IncidentDTO;

import java.util.List;

public class IncidentFullDTO {

    private IncidentDTO incident;
    private List<CarIncidentDTO> cars;
    private List<FireBrigadeIncidentDTO> fireBrigades;

    public IncidentDTO getIncident() {
        return incident;
    }

    public void setIncident(IncidentDTO incident) {
        this.incident = incident;
    }

    public List<CarIncidentDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarIncidentDTO> cars) {
        this.cars = cars;
    }

    public List<FireBrigadeIncidentDTO> getFireBrigades() {
        return fireBrigades;
    }

    public void setFireBrigades(List<FireBrigadeIncidentDTO> fireBrigades) {
        this.fireBrigades = fireBrigades;
    }
}
