package com.firebrigadeserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "firebrigade_incident")
public class FirebrigadeIncident implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_incident")
    @JsonBackReference
    private Incident incident;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_firebrigade")
    @JsonManagedReference
    private FireBrigade fireBrigade;

    @Column(name = "datetime_of_alarm", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeOfAlarm;

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

    public Date getDateTimeOfAlarm() {
        return dateTimeOfAlarm;
    }

    public void setDateTimeOfAlarm(Date dateTimeOfAlarm) {
        this.dateTimeOfAlarm = dateTimeOfAlarm;
    }
}
