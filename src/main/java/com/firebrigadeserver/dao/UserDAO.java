package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        try {
            String hql = "from User as user order by user.userId";
            return (List<User>) entityManager.createQuery(hql).getResultList();
        } catch (Exception e) {
            logger.error("Blad przy pobieraniu uzytkownikow", e.getMessage());
        }
        return null;
    }

    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        User updateUser = getUserById(user.getUserId());
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        updateUser.setFireBrigade(user.getFireBrigade());
        entityManager.flush();
    }

    @Override
    public void deleteUser(int userId) {
        entityManager.remove(getUserById(userId));
    }

    @Override
    public boolean userExist(String login, String password) {
        String hql = "FROM User as user where username = :username and password = :password";
        int count = entityManager.createQuery(hql)
                .setParameter("username", login)
                .setParameter("password", password).getResultList().size();
        return count > 0 ? true : false;
    }
}