package com.firebrigadeserver.dao;

public interface InterfaceTrainingDAO {

    boolean insertTraining(String name);

    boolean updateTraining(int id, String name);

    boolean deleteTraining(int id);

    boolean selectTraining(int id);

    boolean selectTraining(String name);
}
