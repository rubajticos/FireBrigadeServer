package com.firebrigadeserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "training")
public class Training implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTraining;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "training")
    @JsonIgnoreProperties("training")
    private List<FirefighterTraining> firefighterTrainings;

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

    public List<FirefighterTraining> getFirefighterTrainings() {
        return firefighterTrainings;
    }

    public void setFirefighterTrainings(List<FirefighterTraining> firefighterTrainings) {
        this.firefighterTrainings = firefighterTrainings;
    }
}


