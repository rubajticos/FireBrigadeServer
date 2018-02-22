package com.rubajticos.database.interfaces;

import com.rubajticos.model.FireBrigade;
import com.rubajticos.model.User;

public interface InterfaceUserDAO {

    int login(User user);

    boolean register(FireBrigade firebrigade);
}
