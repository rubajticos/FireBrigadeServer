package com.firebrigadeserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "firefighter")
public class Firefighter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_firefighter", unique = true, nullable = false)
    private int idFirefighter;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "expiry_medical_test")
    private Date expiryMedicalTest;

    @ManyToOne
    @JoinColumn(name = "id_fire_brigade")
    @JsonBackReference
    private FireBrigade fireBrigade;

    @OneToMany(mappedBy = "firefighter")
    @JsonManagedReference
    private List<FirefighterTraining> trainings;

    @ManyToMany(mappedBy = "firefighters", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<CarIncident> carsAndIncidents;

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


    public int getIdFirefighter() {
        return idFirefighter;
    }

    public void setIdFirefighter(int idFirefighter) {
        this.idFirefighter = idFirefighter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getExpiryMedicalTest() {
        return expiryMedicalTest;
    }

    public void setExpiryMedicalTest(Date expiryMedicalTest) {
        this.expiryMedicalTest = expiryMedicalTest;
    }


    public FireBrigade getFireBrigade() {
        return fireBrigade;
    }

    public void setFireBrigade(FireBrigade fireBrigade) {
        this.fireBrigade = fireBrigade;
    }

    public List<FirefighterTraining> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<FirefighterTraining> trainings) {
        this.trainings = trainings;
    }

    public List<CarIncident> getCarsAndIncidents() {
        return carsAndIncidents;
    }

    public void setCarsAndIncidents(List<CarIncident> carsAndIncidents) {
        this.carsAndIncidents = carsAndIncidents;
    }
}
