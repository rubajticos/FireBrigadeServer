package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Training;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TrainingDAO implements ITrainingDAO {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Training> getAllTrainings() {
        try {
            String hql = "from Training as trn order by trn.idTraining";
            log.debug("Getting all trainings");
            return (List<Training>) entityManager.createQuery(hql).getResultList();
        } catch (Exception e) {
            log.error("Error on getting all trainings", e.getMessage());
        }
        return null;
    }
}
