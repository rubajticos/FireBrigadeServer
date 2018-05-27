package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.entity.FireBrigade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    List<Equipment> findByFireBrigadeOrderByEquipmentOnTheCar_CarAscNameAsc(FireBrigade fireBrigade);

    boolean existsByNameAndType(String name, String type);
}
