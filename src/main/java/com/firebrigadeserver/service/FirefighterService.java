package com.firebrigadeserver.service;

import com.firebrigadeserver.dao.IFirefighterDAO;
import com.firebrigadeserver.entity.Firefighter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirefighterService implements IFirefighterService {

    @Autowired
    private IFirefighterDAO firefighterDAO;

    @Override
    public List<Firefighter> getAllFirefighters() {
        return firefighterDAO.getAllFirefighters();
    }

    @Override
    public Firefighter getFireFighterById(int firefighterId) {
        return firefighterDAO.getFirerighterById(firefighterId);
    }

    @Override
    public boolean addFirefighter(Firefighter firefighter) {
        if (firefighterDAO.firefighterExist(firefighter.getName(), firefighter.getLastName(), firefighter.getBirthday())) {
            return false;
        } else {
            firefighterDAO.addFirefighter(firefighter);
            return true;
        }
    }

    @Override
    public void updateFirefighter(Firefighter firefighter) {
        firefighterDAO.updateFirefighter(firefighter);
    }

    @Override
    public void deleteFirefighter(int firefighterId) {
        firefighterDAO.deleterFirefighter(firefighterId);
    }
}
