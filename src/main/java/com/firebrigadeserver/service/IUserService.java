package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(int userId);

    User getUserByUsername(String username);

    boolean addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);
}
