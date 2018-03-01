package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.User;

public interface InterfaceUserDAO {

    int login(User user);

    User save(User user);
}
