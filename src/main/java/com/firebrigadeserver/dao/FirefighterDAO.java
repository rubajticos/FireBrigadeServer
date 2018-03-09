package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Firefighter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class FirefighterDAO implements IFirefighterDAO {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager entityManager;

    public FirefighterDAO() {
    }


    @Override
    public List<Firefighter> getAllFirefighters() {
        try {
            String hql = "from Firefighter as ff order by ff.idFirefighter";
            return (List<Firefighter>) entityManager.createQuery(hql).getResultList();
        } catch (Exception e) {
            logger.error("Blad przy pobieraniu strazakow", e.getMessage());
        }
        return null;
    }

    @Override
    public Firefighter getFirerighterById(int firefighterId) {
        return entityManager.find(Firefighter.class, firefighterId);
    }

    @Override
    public void addFirefighter(Firefighter firefighter) {
        entityManager.persist(firefighter);
    }

    @Override
    public void updateFirefighter(Firefighter firefighter) {
        Firefighter updateFirefighter = getFirerighterById(firefighter.getIdFirefighter());
        updateFirefighter.setName(firefighter.getName());
        updateFirefighter.setLastName(firefighter.getLastName());
        updateFirefighter.setBirthday(firefighter.getBirthday());
        updateFirefighter.setExpiryMedicalTest(firefighter.getExpiryMedicalTest());
        updateFirefighter.setFireBrigade(firefighter.getFireBrigade());
        updateFirefighter.setTrainings(firefighter.getTrainings());
        updateFirefighter.setCarsAndIncidents(firefighter.getCarsAndIncidents());
        entityManager.flush();
    }

    @Override
    public void deleterFirefighter(int firefighterId) {
        entityManager.remove(getFirerighterById(firefighterId));
    }

    @Override
    public boolean firefighterExist(String name, String lastname, Date birthday) {
        String hql = "freom Firefighter as ff where" +
                "name = :name and" +
                "lastname = :lastname and" +
                "birthday = :birthday";
        int count = entityManager.createQuery(hql)
                .setParameter("name", name)
                .setParameter("lastname", lastname)
                .setParameter("birthday", birthday).getResultList().size();
        return count > 0 ? true : false;
    }
}
