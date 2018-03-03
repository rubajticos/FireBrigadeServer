package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "firefighter_training")
public class FirefighterTraining {

    @ManyToOne
    @JoinColumn(name = "id_firefighter")
    private Firefighter firefighter;

    @ManyToOne
    @JoinColumn(name = "id_training")
    private Training training;

    @Column(name = "training_date")
    private Date trainigDate;

}
