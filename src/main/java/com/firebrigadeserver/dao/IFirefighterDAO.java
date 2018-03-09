package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Firefighter;

import java.util.Date;
import java.util.List;

public interface IFirefighterDAO {

    List<Firefighter> getAllFirefighters();

    Firefighter getFirerighterById(int firefighterId);

    void addFirefighter(Firefighter firefighter);

    void updateFirefighter(Firefighter firefighter);

    void deleterFirefighter(int firefighterId);

    boolean firefighterExist(String name, String lastname, Date birthday);

}
