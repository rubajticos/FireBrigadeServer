package com.firebrigadeserver.dao;

import com.firebrigadeserver.entity.Incident;
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
public class IncidentDAO implements IIncidentDAO {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Incident> getAllIncidents() {
        try {
            String hql = "from Incident as inc order by inc.id";
            log.debug("Get all incidents");
            return (List<Incident>) entityManager.createQuery(hql).getResultList();
        } catch (Exception e) {
            log.error("Error on get all incidents", e.getMessage());
        }
        return null;
    }

    @Override
    public Incident getIncidentById(int incidentId) {
        return entityManager.find(Incident.class, incidentId);
    }

    @Override
    public void addIncident(Incident incident) {
        entityManager.persist(incident);
    }

    @Override
    public void updateIncident(Incident incident) {
        Incident updateIncident = getIncidentById(incident.getId());
        updateIncident.setType(incident.getType());
        updateIncident.setDate(incident.getDate());
        updateIncident.setCity(incident.getCity());
        updateIncident.setDescription(incident.getDescription());
        updateIncident.setCars(incident.getCars());
        updateIncident.setFireBrigades(incident.getFireBrigades());
    }

    @Override
    public void deleteIncident(int incidentId) {
        entityManager.remove(incidentId);
    }

    @Override
    public boolean incidentExist(String type, Date date, String city, String description) {
        String hql = "from Incident as inc where" +
                "type = type and date = :date and city = :city and description = :description";
        int count = entityManager.createQuery(hql)
                .setParameter("type", type)
                .setParameter("date", date)
                .setParameter("city", city)
                .setParameter("description", description).getResultList().size();
        return count > 0 ? true : false;
    }
}
