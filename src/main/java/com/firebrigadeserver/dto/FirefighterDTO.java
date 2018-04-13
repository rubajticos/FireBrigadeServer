package com.firebrigadeserver.dto;

import java.util.Date;
import java.util.List;

public class FirefighterDTO {

    private int idFirefighter;
    private String name;
    private String lastName;
    private Date birthday;
    private Date expiryMedicalTest;
    private List<FirefighterTrainingDTO> trainings;

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

    public List<FirefighterTrainingDTO> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<FirefighterTrainingDTO> trainings) {
        this.trainings = trainings;
    }
}
