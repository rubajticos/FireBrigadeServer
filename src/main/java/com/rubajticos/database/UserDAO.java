package com.rubajticos.database;

import com.rubajticos.database.interfaces.InterfaceUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements InterfaceUserDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public int login(String username, String password) {

        String query = "select id_user from user where username = ? and password = ? ;";
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
        return result;
    }

    @Override
    public boolean register(String username, String password, String name, String voivodeship, String district, String community, String city, int ksrg) {
        return false;
    }
}