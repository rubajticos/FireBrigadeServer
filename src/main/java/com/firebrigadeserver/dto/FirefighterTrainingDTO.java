package com.firebrigadeserver.dto;

import java.util.Date;

public class FirefighterTrainingDTO {

    private int idFirefighterTraining;
    private FirefighterDTO firefighter;
    private TrainingDTO training;
    private Date trainingDate;

    public int getIdFirefighterTraining() {
        return idFirefighterTraining;
    }

    public void setIdFirefighterTraining(int idFirefighterTraining) {
        this.idFirefighterTraining = idFirefighterTraining;
    }

    public FirefighterDTO getFirefighter() {
        return firefighter;
    }

    public void setFirefighter(FirefighterDTO firefighter) {
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
