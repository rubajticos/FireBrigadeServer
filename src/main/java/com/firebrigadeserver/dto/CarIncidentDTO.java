package com.firebrigadeserver.dto;

import java.util.Date;
import java.util.List;

public class CarIncidentDTO {

    private int idCarIncident;
    private CarDTO car;
    private IncidentDTO incident;
    private FirefighterDTO commander;
    private FirefighterDTO driver;
    private Date dateTimeOfDeparture;
    private Date dateTimeOfReturn;
    private List<FirefighterDTO> firefighters;
    private List<EquipmentDTO> usedEquipments;

    public CarIncidentDTO() {
    }

    public int getIdCarIncident() {
        return idCarIncident;
    }

    public void setIdCarIncident(int idCarIncident) {
        this.idCarIncident = idCarIncident;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public IncidentDTO getIncident() {
        return incident;
    }

    public void setIncident(IncidentDTO incident) {
        this.incident = incident;
    }

    public FirefighterDTO getCommander() {
        return commander;
    }

    public void setCommander(FirefighterDTO commander) {
        this.commander = commander;
    }

    public FirefighterDTO getDriver() {
        return driver;
    }

    public void setDriver(FirefighterDTO driver) {
        this.driver = driver;
    }

    public Date getDateTimeOfDeparture() {
        return dateTimeOfDeparture;
    }

    public void setDateTimeOfDeparture(Date dateTimeOfDeparture) {
        this.dateTimeOfDeparture = dateTimeOfDeparture;
    }

    public Date getDateTimeOfReturn() {
        return dateTimeOfReturn;
    }

    public void setDateTimeOfReturn(Date dateTimeOfReturn) {
        this.dateTimeOfReturn = dateTimeOfReturn;
    }

    public List<FirefighterDTO> getFirefighters() {
        return firefighters;
    }

    public void setFirefighters(List<FirefighterDTO> firefighters) {
        this.firefighters = firefighters;
    }

    public List<EquipmentDTO> getUsedEquipments() {
        return usedEquipments;
    }

    public void setUsedEquipments(List<EquipmentDTO> usedEquipments) {
        this.usedEquipments = usedEquipments;
    }
}
