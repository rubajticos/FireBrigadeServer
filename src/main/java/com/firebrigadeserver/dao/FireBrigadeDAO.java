package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.FireBrigade;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FireBrigadeDAO implements InterfaceFireBrigadeDAO {
    final static Logger logger = Logger.getLogger(UserDAO.class);

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FireBrigade");
    EntityManager manager = null;

    public FireBrigadeDAO() {

    }

    @Override
    public FireBrigade insert(FireBrigade fireBrigade) {
        try {
            manager = entityManagerFactory.createEntityManager();
            return insertFireBrigade(fireBrigade);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    private FireBrigade insertFireBrigade(FireBrigade fireBrigade) throws Exception {
        FireBrigade result;
        manager.getTransaction().begin();
        result = manager.merge(fireBrigade);
        manager.getTransaction().commit();
        manager.close();
        return result;
    }

    @Override
    public boolean updateFireBrigade(int id, String name, String voivodeship, String district, String community, String city, int ksrg) {
        return false;
    }

    @Override
    public boolean deleteFireBrigade(int id) {
        return false;
    }

    @Override
    public FireBrigade selectFireBrigade(int id) {
        return null;
    }

    @Override
    public FireBrigade selectFireBrigade(String username, String password) {
        return null;
    }
}
