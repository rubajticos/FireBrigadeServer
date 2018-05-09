package com.firebrigadeserver.dto;

public class CarDTO {

    private int id;
    private String model;
    private String operationalNumbers;
    private String plates;
    private String type;
    private int water;
    private int foam;
    private int motorPumpPerformance;

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
}
