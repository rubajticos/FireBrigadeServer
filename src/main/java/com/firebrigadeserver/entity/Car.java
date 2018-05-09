package com.firebrigadeserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car", unique = true, nullable = false)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "operational_numbers")
    private String operationalNumbers;

    @Column(name = "plates")
    private String plates;

    @Column(name = "type")
    private String type;

    @Column(name = "water")
    private int water;

    @Column(name = "foam")
    private int foam;

    @Column(name = "motor_pump_performance")
    private int motorPumpPerformance;

    @ManyToOne
    @JoinColumn(name = "id_fire_brigade")
    @JsonBackReference
    private FireBrigade fireBrigade;

    @OneToMany(mappedBy = "car")
    @JsonManagedReference
    private List<CarEquipment> equipment;

    @OneToMany(mappedBy = "incident")
    @JsonBackReference
    private List<CarIncident> incidents;

    public Car() {
        this(-1, null, null, null, null, -1, -1, -1, null, null, null);
    }

    public Car(int id, String model, String operationalNumbers, String plates, String type, int water, int foam, int motorPumpPerformance) {
        this(id, model, operationalNumbers, plates, type, water, foam, motorPumpPerformance, null, null, null);
    }

    public Car(int id, String model, String operationalNumbers, String plates, String type, int water, int foam, int motorPumpPerformance, FireBrigade fireBrigade, List<CarEquipment> equipment, List<CarIncident> incidents) {
        this.id = id;
        this.model = model;
        this.operationalNumbers = operationalNumbers;
        this.plates = plates;
        this.type = type;
        this.water = water;
        this.foam = foam;
        this.motorPumpPerformance = motorPumpPerformance;
        this.fireBrigade = fireBrigade;
        this.equipment = equipment;
        this.incidents = incidents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperationalNumbers() {
        return operationalNumbers;
    }

    public void setOperationalNumbers(String operationalNumbers) {
        this.operationalNumbers = operationalNumbers;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getFoam() {
        return foam;
    }

    public void setFoam(int foam) {
        this.foam = foam;
    }

    public int getMotorPumpPerformance() {
        return motorPumpPerformance;
    }

    public void setMotorPumpPerformance(int motorPumpPerformance) {
        this.motorPumpPerformance = motorPumpPerformance;
    }


    public FireBrigade getFireBrigade() {
        return fireBrigade;
    }

    public void setFireBrigade(FireBrigade fireBrigadeId) {
        this.fireBrigade = fireBrigadeId;
    }

    public List<CarEquipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<CarEquipment> equipment) {
        this.equipment = equipment;
    }

    public List<CarIncident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<CarIncident> incidents) {
        this.incidents = incidents;
    }
}
