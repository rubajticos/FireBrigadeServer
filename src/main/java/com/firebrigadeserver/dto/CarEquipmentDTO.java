package com.firebrigadeserver.dto;

import java.util.Date;

public class CarEquipmentDTO {

    private int carEquipmentId;
    private CarDTO car;
    private EquipmentDTO equipment;
    private int qty;
    private Date dateOfPut;
    private Date dateOfWithdrawal;

    public CarEquipmentDTO() {
    }

    public int getCarEquipmentId() {
        return carEquipmentId;
    }

    public void setCarEquipmentId(int carEquipmentId) {
        this.carEquipmentId = carEquipmentId;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public EquipmentDTO getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentDTO equipment) {
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
