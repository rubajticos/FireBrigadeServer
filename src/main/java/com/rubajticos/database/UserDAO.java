package com.rubajticos.database;

import com.rubajticos.database.interfaces.InterfaceUserDAO;
import com.rubajticos.model.FireBrigade;
import com.rubajticos.model.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements InterfaceUserDAO {
    final static Logger logger = Logger.getLogger(UserDAO.class);

    private Connection connection;
    private PreparedStatement preparedStatement;

    public int login(User user) {
        try {
            return loginUserAndReturnId(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            DbUtil.close(preparedStatement);
            DbUtil.close(connection);
        }
        return -1;
    }

    private int loginUserAndReturnId(User user) throws SQLException, NullPointerException {

        String query = "select id_user from usera where username = ? and password = ? ;";
        ResultSet rs = null;

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        rs = preparedStatement.executeQuery();
        if (rs.next()) {
            int result = rs.getInt(1);
            DbUtil.close(rs);
            return result;
        } else {
            DbUtil.close(rs);
            return -1;
        }


    }

    @Override
    public boolean register(FireBrigade firebrigade) {
        try {

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public boolean registerFirebrigade(FireBrigade fireBrigade) {
        return false;
    }
}