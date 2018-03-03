package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "car_incident")
public class CarIncident {

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_incident")
    private Incident incident;

    @Column(name = "datetime_of_departure")
    private LocalDateTime dateTimeOfDeparture;

    @Column(name = "datetime_of_return")
    private LocalDateTime dateTimeOfReturn;

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

    public LocalDateTime getDateTimeOfDeparture() {
        return dateTimeOfDeparture;
    }

    public void setDateTimeOfDeparture(LocalDateTime dateTimeOfDeparture) {
        this.dateTimeOfDeparture = dateTimeOfDeparture;
    }

    public LocalDateTime getDateTimeOfReturn() {
        return dateTimeOfReturn;
    }

    public void setDateTimeOfReturn(LocalDateTime dateTimeOfReturn) {
        this.dateTimeOfReturn = dateTimeOfReturn;
    }
}
