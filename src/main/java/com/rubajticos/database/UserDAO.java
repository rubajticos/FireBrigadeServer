package com.rubajticos.database;

import com.rubajticos.database.interfaces.InterfaceUserDAO;
import com.rubajticos.model.User;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class UserDAO implements InterfaceUserDAO {
    final static Logger logger = Logger.getLogger(UserDAO.class);

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FireBrigade");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = null;

    public int login(User user) {
        return 0;
    }

    private int loginUserAndReturnId(User user) throws SQLException, NullPointerException {

        return 0;

    }

    @Override
    public boolean register(User user) {
        try {
            return registerUser(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    private boolean registerUser(User user) throws Exception {
        transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(user);
        transaction.commit();
        manager.close();
        entityManagerFactory.close();
        return true;
    }
}