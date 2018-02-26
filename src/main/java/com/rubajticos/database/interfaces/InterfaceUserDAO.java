package com.rubajticos.database.interfaces;

import com.rubajticos.model.User;

public interface InterfaceUserDAO {

    int login(User user);

    User save(User user);
}
