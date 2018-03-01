package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.*;

import java.util.Date;
import java.util.HashSet;

public interface InterfaceIncidentDAO {

    int insertIncident(String type, Date date, String city, String decription,
                       HashSet<Firefighter> firefighters, HashSet<FireBrigade> fireBrigades,
                       HashSet<Equipment> equipments, HashSet<Car> cars);

    boolean updateIncident(int id, String type, Date date, String city, String decription,
                           HashSet<Firefighter> firefighters, HashSet<FireBrigade> fireBrigades,
                           HashSet<Equipment> equipments, HashSet<Car> cars);

    boolean deleteIncident(int id);

    HashSet<Incident> selectIncidents(int FirebrigadeId);
}
