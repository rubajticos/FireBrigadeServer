package com.rubajticos.database;

import com.rubajticos.database.interfaces.InterfaceFireBrigadeDAO;
import com.rubajticos.model.FireBrigade;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FireBrigadeDAO implements InterfaceFireBrigadeDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public FireBrigadeDAO() {

    }

    @Override
    public boolean insertFireBrigade(String username, String password, String name, String voivodeship, String district, String community, String city, int ksrg) {
        return false;
    }

    @Override
    public boolean updateFireBrigade(int id, String name, String voivodeship, String district, String community, String city, int ksrg) {
        return false;
    }

    @Override
    public boolean deleteFireBrigade(int id) {
        return false;
    }

    @Override
    public FireBrigade selectFireBrigade(int id) {
        return null;
    }

    @Override
    public FireBrigade selectFireBrigade(String username, String password) {
        return null;
    }
}
