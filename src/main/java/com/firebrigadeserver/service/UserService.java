package com.firebrigadeserver.service;

import com.firebrigadeserver.dao.IUserDAO;
import com.firebrigadeserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(int userId) {
        User user = userDAO.getUserById(userId);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        if (userDAO.userExist(user.getUsername(), user.getPassword())) {
            return false;
        } else {
            userDAO.addUser(user);
            return true;
        }
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}
