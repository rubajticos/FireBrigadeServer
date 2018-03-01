package com.firebrigadeserver.entity;

public class Car {

    private int id;
    private String model;
    private String operationalNumbers;
    private String plates;
    private String type;
    private int water;
    private int fireBrigadeId;

    public Car() {
        this(-1, null, null, null, null, -1, -1);
    }

    public Car(int id, String model, String operationalNumbers, String plates, String type, int water, int fireBrigadeId) {
        this.id = id;
        this.model = model;
        this.operationalNumbers = operationalNumbers;
        this.plates = plates;
        this.type = type;
        this.water = water;
        this.fireBrigadeId = fireBrigadeId;
    }
}
