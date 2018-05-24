package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.User;
import com.firebrigadeserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean addUser(User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            return false;
        } else {
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.delete(userId);
    }
}
