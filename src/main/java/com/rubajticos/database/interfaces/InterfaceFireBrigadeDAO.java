package com.rubajticos.database.interfaces;

import com.rubajticos.model.FireBrigade;

public interface InterfaceFireBrigadeDAO {

    FireBrigade insert(FireBrigade fireBrigade);

    boolean updateFireBrigade(int id, String name, String voivodeship, String district, String community, String city, int ksrg);

    boolean deleteFireBrigade(int id);

    FireBrigade selectFireBrigade(int id);

    FireBrigade selectFireBrigade(String username, String password);


}
