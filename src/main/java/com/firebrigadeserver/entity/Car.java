package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "car")
public class Car implements Serializable {

    private int id;
    private String model;
    private String operationalNumbers;
    private String plates;
    private String type;
    private int water;
    private int foam;
    private int motorPumpPerformance;

    private FireBrigade fireBrigade;
    private List<CarEquipment> equipment;

    public Car() {
        this(-1, null, null, null, null, -1, null);
    }

    public Car(int id, String model, String operationalNumbers, String plates, String type, int water, FireBrigade fireBrigade) {
        this.id = id;
        this.model = model;
        this.operationalNumbers = operationalNumbers;
        this.plates = plates;
        this.type = type;
        this.water = water;
        this.fireBrigade = fireBrigade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "operational_numbers")
    public String getOperationalNumbers() {
        return operationalNumbers;
    }

    public void setOperationalNumbers(String operationalNumbers) {
        this.operationalNumbers = operationalNumbers;
    }

    @Column(name = "plates")
    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "water")
    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    @Column(name = "foam")
    public int getFoam() {
        return foam;
    }

    public void setFoam(int foam) {
        this.foam = foam;
    }

    @Column(name = "motor_pump_performance")
    public int getMotorPumpPerformance() {
        return motorPumpPerformance;
    }

    public void setMotorPumpPerformance(int motorPumpPerformance) {
        this.motorPumpPerformance = motorPumpPerformance;
    }

    @ManyToOne()
    @JoinColumn(name = "id_fire_brigade")
    public FireBrigade getFireBrigade() {
        return fireBrigade;
    }

    public void setFireBrigade(FireBrigade fireBrigadeId) {
        this.fireBrigade = fireBrigadeId;
    }

    @OneToMany(mappedBy = "car")
    public List<CarEquipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<CarEquipment> equipment) {
        this.equipment = equipment;
    }
}
