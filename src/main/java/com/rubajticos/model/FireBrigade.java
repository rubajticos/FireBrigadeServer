package com.rubajticos.model;

import java.util.HashSet;

public class FireBrigade {

    private int idFireBrigade;
    private String name;
    private String voivodeship;
    private String district;
    private String community;
    private String city;
    private boolean ksrg;

    private HashSet<Firefighter> firefighters;

    public FireBrigade() {
        this(-1, null, null, null, null, null, null);
    }

    public FireBrigade(int id, String name) {
        this(id, name, null, null, null, null, null);
    }

    public FireBrigade(int id, String name, String voivodeship, String district, String community, String city, Boolean ksrg) {
        this.idFireBrigade = id;
        this.name = name;
        this.voivodeship = voivodeship;
        this.district = district;
        this.community = community;
        this.city = city;
        this.ksrg = ksrg;
    }

    public int getIdFireBrigade() {
        return idFireBrigade;
    }

    public void setIdFireBrigade(int idFireBrigade) {
        this.idFireBrigade = idFireBrigade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isKsrg() {
        return ksrg;
    }

    public void setKsrg(boolean ksrg) {
        this.ksrg = ksrg;
    }

    public HashSet<Firefighter> getFirefighters() {
        return firefighters;
    }

    public void setFirefighters(HashSet<Firefighter> firefighters) {
        this.firefighters = firefighters;
    }
}
