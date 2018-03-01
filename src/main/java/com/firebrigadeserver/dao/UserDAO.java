package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
    final static Logger logger = Logger.getLogger(UserDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        try {
            String hql = "FROM User as user ORDER by user.userId";
            return (List<User>) entityManager.createQuery(hql).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
//        updateUser.setFireBrigade(user.getFireBrigade());
        entityManager.flush();
    }

    @Override
    public void deleteUser(int userId) {
        entityManager.remove(getUserById(userId));
    }

    @Override
    public boolean userExist(String login, String password) {
        String hql = "FROM User as user where user.username = ? and user.password = ?";
        int count = entityManager.createQuery(hql)
                .setParameter(1, login)
                .setParameter(2, password).getResultList().size();
        return count > 0 ? true : false;
    }
}