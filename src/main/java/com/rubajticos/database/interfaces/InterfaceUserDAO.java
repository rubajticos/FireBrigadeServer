package com.rubajticos.database.interfaces;

public interface InterfaceUserDAO {

    boolean login(String username, String password);

    boolean register(String username, String password, String name, String voivodeship, String district, String community, String city, int ksrg);
}