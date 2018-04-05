package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class FireBrigadeDAO implements IFireBrigadeDAO {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<FireBrigade> getAllFireBrigades() {
        try {
            String hql = "from FireBrigade as fb order by fb.idFireBrigade";
            logger.info("Pobrano wszystkie jednostki!");
            return (List<FireBrigade>) entityManager.createQuery(hql).getResultList();
        } catch (Exception e) {
            logger.error("Blad przy pobieraniu jednostek strazy pozarnej", e.getMessage());
        }
        return null;
    }

    @Override
    public FireBrigade getFireBrigadeById(int fireBrigadeId) {
        return entityManager.find(FireBrigade.class, fireBrigadeId);
    }

    public FireBrigade getFireBrigadeByUser(User user) {
        String hql = "from FireBrigade as fb where fb.user = :user";
        return (FireBrigade) entityManager.createQuery(hql).setParameter("user", user).getSingleResult();
    }

    @Override
    public void addFireBrigade(FireBrigade fireBrigade) {
        entityManager.persist(fireBrigade);
    }

    @Override
    public void updateFireBrigade(FireBrigade fireBrigade) {
        FireBrigade updateFireBrigade = getFireBrigadeById(fireBrigade.getIdFireBrigade());
        updateFireBrigade.setName(fireBrigade.getName());
        updateFireBrigade.setCars(fireBrigade.getCars());
        updateFireBrigade.setCity(fireBrigade.getCity());
        updateFireBrigade.setCommunity(fireBrigade.getCommunity());
        updateFireBrigade.setDistrict(fireBrigade.getDistrict());
        updateFireBrigade.setVoivodeship(fireBrigade.getVoivodeship());
        updateFireBrigade.setKsrg(fireBrigade.isKsrg());
        updateFireBrigade.setFireBrigadeEquipment(fireBrigade.getFireBrigadeEquipment());
        updateFireBrigade.setFirefighters(fireBrigade.getFirefighters());
        updateFireBrigade.setIncidents(fireBrigade.getIncidents());
        updateFireBrigade.setUser(fireBrigade.getUser());
        entityManager.flush();
    }

    @Override
    public void deleteFireBrigade(int fireBrigadeId) {
        entityManager.remove(getFireBrigadeById(fireBrigadeId));
    }

    @Override
    public boolean fireBrigadeExist(String name, String city, String community, String district, String voivodeship) {
        String hql = "from FireBrigade as fb where name = :name " +
                "and city = :city and community = :community and district = :district and  voivodeship = :voivodeship";
        int count = entityManager.createQuery(hql)
                .setParameter("name", name)
                .setParameter("city", city)
                .setParameter("community", community)
                .setParameter("district", district)
                .setParameter("voivodeship", voivodeship).getResultList().size();
        return count > 0 ? true : false;
    }
}
