package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "firebrigade_incident")
public class FirebrigadeIncident {

    @ManyToOne
    @JoinColumn(name = "id_incident")
    private Incident incident;

    @ManyToOne
    @JoinColumn(name = "id_firebrigade")
    private FireBrigade fireBrigade;

    @Column(name = "datetime_of_alarm")
    private DateTimeFormatter dateTimeOfAlarm;

    public FirebrigadeIncident() {
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public FireBrigade getFireBrigade() {
        return fireBrigade;
    }

    public void setFireBrigade(FireBrigade fireBrigade) {
        this.fireBrigade = fireBrigade;
    }

    public DateTimeFormatter getDateTimeOfAlarm() {
        return dateTimeOfAlarm;
    }

    public void setDateTimeOfAlarm(DateTimeFormatter dateTimeOfAlarm) {
        this.dateTimeOfAlarm = dateTimeOfAlarm;
    }
}
