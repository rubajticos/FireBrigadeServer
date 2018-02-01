package com.rubajticos.database;

import com.rubajticos.database.interfaces.InterfaceFirefighterDAO;
import com.rubajticos.model.Firefighter;

import java.util.Date;
import java.util.HashSet;

public class FirefighterDAO implements InterfaceFirefighterDAO {

    public FirefighterDAO() {
    }

    @Override
    public boolean insertFirefighter(String name, String lastName, Date birthday, Date expiryMedicalTest, int fireBrigadeId) {
        return false;
    }

    @Override
    public boolean updateFirefighter(int id, String name, String lastName, Date birthday, Date expiryMedicalTest, int fireBrigadeId) {
        return false;
    }

    @Override
    public boolean deleteFirefighter(int id) {
        return false;
    }

    @Override
    public Firefighter selectFirefighter(int id) {
        return null;
    }

    @Override
    public Firefighter selectFirefighter(String name, String lastname) {
        return null;
    }

    @Override
    public Firefighter selectFirefighter(String name, String lastname, String FireBrigadeName) {
        return null;
    }

    @Override
    public HashSet<Firefighter> selectFirefighters(int idFireBrigade) {
        return null;
    }
}
