package com.firebrigadeserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "firefighter_training")
public class FirefighterTraining implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_firefighter_training", unique = true, nullable = false)
    private int idFirefighterTraining;

    @ManyToOne
    @JoinColumn(name = "id_firefighter")
    @JsonBackReference
    private Firefighter firefighter;

    @ManyToOne
    @JoinColumn(name = "id_training")
    @JsonManagedReference
    private Training training;

    @Column(name = "training_date", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date trainingDate;

    public int getIdFirefighterTraining() {
        return idFirefighterTraining;
    }

    public void setIdFirefighterTraining(int idFirefighterTraining) {
        this.idFirefighterTraining = idFirefighterTraining;
    }

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

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }
}
