package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "car_equipment")
public class CarEquipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_equipment", unique = true, nullable = false)
    private int carEquipmentId;

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_equipment")
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

    public int getCarEquipmentId() {
        return carEquipmentId;
    }

    public void setCarEquipmentId(int carEquipmentId) {
        this.carEquipmentId = carEquipmentId;
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
