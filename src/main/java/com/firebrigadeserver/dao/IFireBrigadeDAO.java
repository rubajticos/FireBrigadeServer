package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.FireBrigade;

import java.util.List;

public interface IFireBrigadeDAO {

    List<FireBrigade> getAllFireBrigades();

    FireBrigade getFireBrigadeById(int fireBrigadeId);

    void addFireBrigade(FireBrigade fireBrigade);

    void updateFireBrigade(FireBrigade fireBrigade);

    void deleteFireBrigade(int fireBrigadeId);

    boolean fireBrigadeExist(String name, String city, String community, String district, String voivodeship);


}
