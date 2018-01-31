package com.rubajticos.model;

public class Training {

    private int idTraining;
    private String name;

    public Training() {
        this(-1, null);
    }

    public Training(int idTraining, String name) {
        this.idTraining = idTraining;
        this.name = name;
    }

    public int getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(int idTraining) {
        this.idTraining = idTraining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


