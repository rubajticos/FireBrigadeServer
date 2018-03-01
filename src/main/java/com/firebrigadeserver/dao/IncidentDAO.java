package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.*;

import java.util.Date;
import java.util.HashSet;

public class IncidentDAO implements InterfaceIncidentDAO {
    @Override
    public int insertIncident(String type, Date date, String city, String decription, HashSet<Firefighter> firefighters, HashSet<FireBrigade> fireBrigades, HashSet<Equipment> equipments, HashSet<Car> cars) {
        return 0;
    }

    @Override
    public boolean updateIncident(int id, String type, Date date, String city, String decription, HashSet<Firefighter> firefighters, HashSet<FireBrigade> fireBrigades, HashSet<Equipment> equipments, HashSet<Car> cars) {
        return false;
    }

    @Override
    public boolean deleteIncident(int id) {
        return false;
    }

    @Override
    public HashSet<Incident> selectIncidents(int FirebrigadeId) {
        return null;
    }
}
