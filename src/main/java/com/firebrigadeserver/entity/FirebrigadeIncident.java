package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "firebrigade_incident")
public class FirebrigadeIncident implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_firebrigade_incident", nullable = false, unique = true)
    private int idFirebrigadeIncident;

    @ManyToOne
    @JoinColumn(name = "id_incident")
    private Incident incident;

    @ManyToOne
    @JoinColumn(name = "id_firebrigade")
    private FireBrigade fireBrigade;

    @Column(name = "datetime_of_alarm", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeOfAlarm;

    public FirebrigadeIncident() {
    }

    public int getIdFirebrigadeIncident() {
        return idFirebrigadeIncident;
    }

    public void setIdFirebrigadeIncident(int idFirebrigadeIncident) {
        this.idFirebrigadeIncident = idFirebrigadeIncident;
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
