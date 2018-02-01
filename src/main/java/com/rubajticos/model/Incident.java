package com.rubajticos.model;

import javax.xml.crypto.Data;
import java.util.HashSet;

public class Incident {

    private int id;
    private String description;
    private String type;
    private Data date;
    private String city;

    private HashSet<FireBrigade> fireBrigades;
    private HashSet<HashSet<Car>> cars;
    private HashSet<HashSet<Firefighter>> firefighters;
    private HashSet<HashSet<Equipment>> equipments;

    public Incident() {
        this(-1, null, null, null, null);
    }

    public Incident(int id, String description, String type, Data date, String city) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.date = date;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public HashSet<FireBrigade> getFireBrigades() {
        return fireBrigades;
    }

    public void setFireBrigades(HashSet<FireBrigade> fireBrigades) {
        this.fireBrigades = fireBrigades;
    }

    public HashSet<HashSet<Car>> getCars() {
        return cars;
    }

    public void setCars(HashSet<HashSet<Car>> cars) {
        this.cars = cars;
    }

    public HashSet<HashSet<Firefighter>> getFirefighters() {
        return firefighters;
    }

    public void setFirefighters(HashSet<HashSet<Firefighter>> firefighters) {
        this.firefighters = firefighters;
    }

    public HashSet<HashSet<Equipment>> getEquipments() {
        return equipments;
    }

    public void setEquipments(HashSet<HashSet<Equipment>> equipments) {
        this.equipments = equipments;
    }
}
