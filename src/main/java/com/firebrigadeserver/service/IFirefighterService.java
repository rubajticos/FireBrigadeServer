package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.Firefighter;

import java.util.List;

public interface IFirefighterService {

    List<Firefighter> getAllFirefighters();

    Firefighter getFireFighterById(int firefighterId);

    boolean addFirefighter(Firefighter firefighter);

    void updateFirefighter(Firefighter firefighter);

    void deleteFirefighter(int firefighterId);
}
