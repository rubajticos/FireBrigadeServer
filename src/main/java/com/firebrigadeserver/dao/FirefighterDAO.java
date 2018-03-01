package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Firefighter;

import java.util.Date;
import java.util.HashSet;

public class FirefighterDAO implements InterfaceFirefighterDAO {

    public FirefighterDAO() {
    }

    @Override
    public boolean insertFirefighter(String name, String lastName, Date birthday, Date expiryMedicalTest, int fireBrigadeId) {
/*        String query = "insert into firefighter(name, last_name, birthday, expiry_medical_test_, id_firebrigade)" +
                "values (?, ?, ?, ?, ?);";
        ResultSet rs = null;
        int result = -1;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            ;
        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return result;*/
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
