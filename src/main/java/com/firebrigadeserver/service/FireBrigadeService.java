package com.firebrigadeserver.service;

import com.firebrigadeserver.dao.IFireBrigadeDAO;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireBrigadeService implements IFireBrigadeService {

    @Autowired
    private IFireBrigadeDAO fireBrigadeDAO;

    @Override
    public List<FireBrigade> getAllFireBrigades() {
        return fireBrigadeDAO.getAllFireBrigades();
    }

    @Override
    public FireBrigade getFireBrigadeById(int fireBrigadeId) {
        FireBrigade fireBrigade = fireBrigadeDAO.getFireBrigadeById(fireBrigadeId);
        return fireBrigade;
    }

    @Override
    public FireBrigade getFireBrigadeByUser(User user) {
        return fireBrigadeDAO.getFireBrigadeByUser(user);
    }

    @Override
    public boolean addFireBrigade(FireBrigade fireBrigade) {
        if (fireBrigadeDAO.fireBrigadeExist(fireBrigade.getName(), fireBrigade.getCity(),
                fireBrigade.getCommunity(), fireBrigade.getDistrict(), fireBrigade.getVoivodeship())) {
            return false;
        } else {
            fireBrigadeDAO.addFireBrigade(fireBrigade);
            return true;
        }
    }

    @Override
    public void updateFireBrigade(FireBrigade fireBrigade) {
        fireBrigadeDAO.updateFireBrigade(fireBrigade);
    }

    @Override
    public void deleteFireBrigade(int fireBrigadeId) {
        fireBrigadeDAO.deleteFireBrigade(fireBrigadeId);
    }
}
