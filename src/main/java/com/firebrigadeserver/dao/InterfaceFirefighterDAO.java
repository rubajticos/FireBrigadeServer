package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Firefighter;

import java.util.Date;
import java.util.HashSet;

public interface InterfaceFirefighterDAO {

    boolean insertFirefighter(String name, String lastName, Date birthday, Date expiryMedicalTest, int fireBrigadeId);

    boolean updateFirefighter(int id, String name, String lastName, Date birthday, Date expiryMedicalTest, int fireBrigadeId);

    boolean deleteFirefighter(int id);

    Firefighter selectFirefighter(int id);

    Firefighter selectFirefighter(String name, String lastname);

    Firefighter selectFirefighter(String name, String lastname, String FireBrigadeName);

    HashSet<Firefighter> selectFirefighters(int idFireBrigade);


}
