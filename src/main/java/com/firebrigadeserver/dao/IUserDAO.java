package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.User;

import java.util.List;

public interface IUserDAO {

    List<User> getAllUsers();

    User getUserById(int userId);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    boolean userExist(String username, String password);
}
