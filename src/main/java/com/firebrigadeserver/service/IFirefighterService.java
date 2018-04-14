package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.Firefighter;

import java.util.List;

public interface IFirefighterService {

    List<Firefighter> getAllFirefighters();

    Firefighter getFireFighterById(int firefighterId);

    Firefighter getFireFighterByFirebrigadeAndNameAndLastName(FireBrigade firebrigade, String name, String lastname);

    Firefighter addFirefighter(Firefighter firefighter);

    Firefighter updateFirefighter(Firefighter firefighter);

    void deleteFirefighter(int firefighterId);
}
