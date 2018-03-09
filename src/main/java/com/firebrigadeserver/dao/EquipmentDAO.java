package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.entity.FireBrigade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class EquipmentDAO implements IEquipmentDAO {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Equipment> getAllEquipment() {
        try {
            String hql = "from Equipment as eq order by eq.id";
            return entityManager.createQuery(hql).getResultList();
        } catch (Exception e) {
            logger.error("Blacz przy pobieraniu sprzetu");
        }
        return null;
    }

    @Override
    public Equipment getEquipmentById(int equipmentId) {
        return entityManager.find(Equipment.class, equipmentId);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        entityManager.persist(equipment);
    }

    @Override
    public void updateEquipment(Equipment equipment) {
        Equipment updateEquipment = getEquipmentById(equipment.getId());
        updateEquipment.setName(equipment.getName());
        updateEquipment.setType(equipment.getType());
        updateEquipment.setFireBrigade(equipment.getFireBrigade());
        updateEquipment.setEquipmentOnTheCar(equipment.getEquipmentOnTheCar());
        entityManager.flush();
    }

    @Override
    public void deleteEquipment(int equipmentId) {
        entityManager.remove(getEquipmentById(equipmentId));
    }

    @Override
    public boolean equipmentExist(String name, String type, FireBrigade fireBrigade) {
        String hql = "from Equipment where name = :name and type = :type and fireBrigade = :fireBrigade";
        int count = entityManager.createQuery(hql)
                .setParameter("name", name)
                .setParameter("type", type)
                .setParameter("fireBrigade", fireBrigade).getResultList().size();
        return count > 0 ? true : false;
    }
}
