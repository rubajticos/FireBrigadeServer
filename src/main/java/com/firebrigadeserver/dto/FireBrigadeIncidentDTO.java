package com.firebrigadeserver.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FireBrigadeIncidentDTO {


    private int idFireBrigadeIncident;
    private IncidentDTO incident;
    private FireBrigadeDTO fireBrigade;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateTimeOfAlarm;

    public FireBrigadeIncidentDTO() {
    }

    public int getIdFireBrigadeIncident() {
        return idFireBrigadeIncident;
    }

    public void setIdFireBrigadeIncident(int idFireBrigadeIncident) {
        this.idFireBrigadeIncident = idFireBrigadeIncident;
    }

    public IncidentDTO getIncident() {
        return incident;
    }

    public void setIncident(IncidentDTO incident) {
        this.incident = incident;
    }

    public FireBrigadeDTO getFireBrigade() {
        return fireBrigade;
    }

    public void setFireBrigade(FireBrigadeDTO fireBrigade) {
        this.fireBrigade = fireBrigade;
    }

    public Date getDateTimeOfAlarm() {
        return dateTimeOfAlarm;
    }

    public void setDateTimeOfAlarm(Date dateTimeOfAlarm) {
        this.dateTimeOfAlarm = dateTimeOfAlarm;
    }
}
