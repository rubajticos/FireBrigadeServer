package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car_equipment")
public class CarEquipment {

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_equipment")
    private Equipment equipment;

    @Column(name = "qty")
    private int qty;

    @Column(name = "date_of_put")
    private Date dateOfPut;

    @Column(name = "date_of_withdrawal")
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
