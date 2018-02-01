package com.rubajticos.database;

import com.rubajticos.database.interfaces.InterfaceTrainingDAO;

public class TrainingDAO implements InterfaceTrainingDAO {

    public TrainingDAO() {
    }

    @Override
    public boolean insertTraining(String name) {
        return false;
    }

    @Override
    public boolean updateTraining(int id, String name) {
        return false;
    }

    @Override
    public boolean deleteTraining(int id) {
        return false;
    }

    @Override
    public boolean selectTraining(int id) {
        return false;
    }

    @Override
    public boolean selectTraining(String name) {
        return false;
    }
}
