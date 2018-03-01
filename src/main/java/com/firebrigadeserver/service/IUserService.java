package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(int userId);

    boolean addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);
}
