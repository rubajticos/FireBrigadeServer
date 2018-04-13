package com.firebrigadeserver.dto;

import java.util.Date;

public class FirefighterTrainingDTO {

    private int idFirefigherTraining;
    private TrainingDTO training;
    private Date trainingDate;

    public int getIdFirefigherTraining() {
        return idFirefigherTraining;
    }

    public void setIdFirefigherTraining(int idFirefigherTraining) {
        this.idFirefigherTraining = idFirefigherTraining;
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
