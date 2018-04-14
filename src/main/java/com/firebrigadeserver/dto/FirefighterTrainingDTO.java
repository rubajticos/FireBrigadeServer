package com.firebrigadeserver.dto;

import java.util.Date;

public class FirefighterTrainingDTO {

    private int idFirefigherTraining;
    private int firefighter;
    private TrainingDTO training;
    private Date trainingDate;

    public int getIdFirefigherTraining() {
        return idFirefigherTraining;
    }

    public void setIdFirefigherTraining(int idFirefigherTraining) {
        this.idFirefigherTraining = idFirefigherTraining;
    }

    public int getFirefighter() {
        return firefighter;
    }

    public void setFirefighter(int firefighter) {
        this.firefighter = firefighter;
    }

    public TrainingDTO getTraining() {
        return training;
    }

    public void setTraining(TrainingDTO training) {
        this.training = training;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }
}
