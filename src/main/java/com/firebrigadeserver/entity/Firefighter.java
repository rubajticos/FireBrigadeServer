package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "firefighter")
public class Firefighter {

    private int idFirefighter;
    private String name;
    private String lastName;
    private Date birthday;
    private Date expiryMedicalTest;
    private FireBrigade fireBrigade;

    private List<FirefighterTraining> trainings;

    public Firefighter() {
        this(-1, null, null, null, null);
    }

    public Firefighter(int idFirefighter, String name, String lastName, Date birthday) {
        this(idFirefighter, name, lastName, birthday, null);
    }

    public Firefighter(int idFirefighter, String name, String lastName, Date birthday, Date expiryMedicalTest) {
        this.idFirefighter = idFirefighter;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.expiryMedicalTest = expiryMedicalTest;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_firefighter", unique = true, nullable = false)
    public int getIdFirefighter() {
        return idFirefighter;
    }

    public void setIdFirefighter(int idFirefighter) {
        this.idFirefighter = idFirefighter;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name = "expiry_medical_test")
    public Date getExpiryMedicalTest() {
        return expiryMedicalTest;
    }

    public void setExpiryMedicalTest(Date expiryMedicalTest) {
        this.expiryMedicalTest = expiryMedicalTest;
    }

    @ManyToOne
    @JoinColumn(name = "id_fire_brigade")
    public FireBrigade getFireBrigade() {
        return fireBrigade;
    }

    public void setFireBrigade(FireBrigade fireBrigade) {
        this.fireBrigade = fireBrigade;
    }

    @OneToMany(mappedBy = "firefighter")
    public List<FirefighterTraining> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<FirefighterTraining> trainings) {
        this.trainings = trainings;
    }
}
