package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.CarEquipment;
import com.firebrigadeserver.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CarEquipmentRepository extends JpaRepository<CarEquipment, Integer> {

    List<CarEquipment> findByCar(Car car);

    List<CarEquipment> findByCarAndDateOfWithDrawalIsNull(Car car);

    List<CarEquipment> findByCarAndDateOfWithDrawalIsNotNull(Car car);

    boolean existsByCarAndEquipmentAndQtyAndDateOfPutAndDateoOfWithDrawal(Car car, Equipment equipment, int qty, Date put, Date withdrawal);

}
