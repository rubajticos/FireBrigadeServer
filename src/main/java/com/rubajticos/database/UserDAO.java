package com.rubajticos.database;

import com.rubajticos.database.interfaces.InterfaceUserDAO;
import com.rubajticos.model.User;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class UserDAO implements InterfaceUserDAO {
    final static Logger logger = Logger.getLogger(UserDAO.class);

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FireBrigade");
    EntityManager manager = null;

    public int login(User user) {
        return 0;
    }

    private int loginUserAndReturnId(User user) throws SQLException, NullPointerException {

        return 0;

    }

    @Override
    public User save(User user) {
        try {
            manager = entityManagerFactory.createEntityManager();
            return saveUser(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    private User saveUser(User user) throws Exception {
        User resultUser;
        manager.getTransaction().begin();
        resultUser = manager.merge(user);
        manager.getTransaction().commit();
        manager.close();
//        entityManagerFactory.close();
        return resultUser;
    }
}