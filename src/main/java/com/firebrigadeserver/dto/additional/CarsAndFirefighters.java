package com.firebrigadeserver.dto.additional;

import com.firebrigadeserver.dto.FirefighterDTO;

import java.util.List;

public class CarsAndFirefighters {

    List<FirefighterDTO> commanders;
    List<FirefighterDTO> drivers;
    List<FirefighterDTO> firefighters;
    List<CarWithEquipment> cars;

    public List<FirefighterDTO> getCommanders() {
        return commanders;
    }

    public void setCommanders(List<FirefighterDTO> commanders) {
        this.commanders = commanders;
    }

    public List<FirefighterDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<FirefighterDTO> drivers) {
        this.drivers = drivers;
    }

    public List<FirefighterDTO> getFirefighters() {
        return firefighters;
    }

    public void setFirefighters(List<FirefighterDTO> firefighters) {
        this.firefighters = firefighters;
    }

    public List<CarWithEquipment> getCars() {
        return cars;
    }

    public void setCars(List<CarWithEquipment> cars) {
        this.cars = cars;
    }
}
