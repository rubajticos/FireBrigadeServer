package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.User;

import java.util.List;

public interface IFireBrigadeService {

    List<FireBrigade> getAllFireBrigades();

    FireBrigade getFireBrigadeById(int fireBrigadeId);

    FireBrigade getFireBrigadeByUser(User user);

    boolean addFireBrigade(FireBrigade fireBrigade);

    void updateFireBrigade(FireBrigade fireBrigade);

    void deleteFireBrigade(int fireBrigadeId);
}
