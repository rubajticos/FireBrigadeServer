package com.firebrigadeserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "firefighter_training")
public class FirefighterTraining implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_firefighter")
    @JsonIgnoreProperties("trainings")
    private Firefighter firefighter;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_training")
    @JsonIgnoreProperties("firefighterTrainings")
    private Training training;

    @Column(name = "training_date", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date trainigDate;

    public Firefighter getFirefighter() {
        return firefighter;
    }

    public void setFirefighter(Firefighter firefighter) {
        this.firefighter = firefighter;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Date getTrainigDate() {
        return trainigDate;
    }

    public void setTrainigDate(Date trainigDate) {
        this.trainigDate = trainigDate;
    }
}
