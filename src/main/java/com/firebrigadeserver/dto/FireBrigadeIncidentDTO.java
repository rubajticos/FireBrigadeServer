package com.firebrigadeserver.dto;

public class FireBrigadeIncidentDTO {


    private int indcidentId;
    private int firebrigadeId;
    private String date;

    public int getIndcidentId() {
        return indcidentId;
    }

    public void setIndcidentId(int indcidentId) {
        this.indcidentId = indcidentId;
    }

    public int getFirebrigadeId() {
        return firebrigadeId;
    }

    public void setFirebrigadeId(int firebrigadeId) {
        this.firebrigadeId = firebrigadeId;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
