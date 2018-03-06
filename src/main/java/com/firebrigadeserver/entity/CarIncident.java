package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "car_incident")
public class CarIncident implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_incident")
    private Incident incident;

    @Column(name = "datetime_of_departure", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeOfDeparture;

    @Column(name = "datetime_of_return", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeOfReturn;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "firefighter_car_incident",
            joinColumns = {
                    @JoinColumn(name = "id_car", nullable = false, updatable = false),
                    @JoinColumn(name = "id_incident", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_firefighter", nullable = false, updatable = false)}
    )
    private List<Firefighter> firefighters;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_equipment_of_car_in_incident",
            joinColumns = {
                    @JoinColumn(name = "id_car", nullable = false, updatable = false),
                    @JoinColumn(name = "id_incident", nullable = false, updatable = false)
            },
            inverseJoinColumns = {@JoinColumn(name = "id_equipment", nullable = false, updatable = false)}
    )
    private List<Equipment> usedEquipments;

    public CarIncident() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
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

    public List<Firefighter> getFirefighters() {
        return firefighters;
    }

    public void setFirefighters(List<Firefighter> firefighters) {
        this.firefighters = firefighters;
    }

    public List<Equipment> getUsedEquipments() {
        return usedEquipments;
    }

    public void setUsedEquipments(List<Equipment> usedEquipments) {
        this.usedEquipments = usedEquipments;
    }
}
