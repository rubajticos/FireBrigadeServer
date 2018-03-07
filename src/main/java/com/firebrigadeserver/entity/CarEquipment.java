package com.firebrigadeserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "car_equipment")
public class CarEquipment implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_car")
    @JsonBackReference
    private Car car;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_equipment")
    @JsonManagedReference
    private Equipment equipment;

    @Column(name = "qty")
    private int qty;

    @Column(name = "date_of_put", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date dateOfPut;

    @Column(name = "date_of_withdrawal", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date dateOfWithdrawal;

    public CarEquipment() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getDateOfPut() {
        return dateOfPut;
    }

    public void setDateOfPut(Date dateOfPut) {
        this.dateOfPut = dateOfPut;
    }

    public Date getDateOfWithdrawal() {
        return dateOfWithdrawal;
    }

    public void setDateOfWithdrawal(Date dateOfWithdrawal) {
        this.dateOfWithdrawal = dateOfWithdrawal;
    }
}
