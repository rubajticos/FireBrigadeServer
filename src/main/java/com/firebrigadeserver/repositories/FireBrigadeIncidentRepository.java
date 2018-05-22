package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.FirebrigadeIncident;
import com.firebrigadeserver.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FireBrigadeIncidentRepository extends JpaRepository<FirebrigadeIncident, Integer> {

    List<FirebrigadeIncident> findByFireBrigade(FireBrigade fireBrigade);

    List<FirebrigadeIncident> findByIncident(Incident incident);

    boolean existsByIncidentAndFireBrigade(Incident incident, FireBrigade fireBrigade);

}
