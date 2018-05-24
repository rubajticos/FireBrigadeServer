package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.Firefighter;

import java.util.List;

public interface IFirefighterService {

    List<Firefighter> getAllFirefighters();

    List<Firefighter> getFirefightersByFirebrigade(int firebrigadeId);

    Firefighter getFireFighterById(int firefighterId);

    Firefighter getFireFighterByFirebrigadeAndNameAndLastName(FireBrigade firebrigade, String name, String lastname);

    Firefighter addFirefighter(Firefighter firefighter);

    Firefighter updateFirefighter(Firefighter firefighter);

    void deleteFirefighter(int firefighterId);

    List<Firefighter> getCommanders(FireBrigade fireBrigade);

    List<Firefighter> getDrivers(FireBrigade fireBrigade);
}
