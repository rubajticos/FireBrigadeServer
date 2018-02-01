package com.rubajticos.database;

import com.rubajticos.database.interfaces.InterfaceUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements InterfaceUserDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public int getFireBrigadeByUser(String username, String password) {
        String query = "select * from fire_brigade where username = ? and password = ? ;";
        ResultSet rs = null;
        int result = -1;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(
                        "Name: " + rs.getString("name") +
                                "\nVoivodeship: " + rs.getString("voivodeship") +
                                "\nDistrict" + rs.getString("district") +
                                "\nCommunity: " + rs.getString("community") +
                                "\nCity: " + rs.getString("city") +
                                "\nKSRG: " + rs.getString("is_in_ksrg")
                );
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DbUtil.close(rs);
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);

        }
        return result;

    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean register(String username, String password, String name, String voivodeship, String district, String community, String city, int ksrg) {
        return false;
    }
}