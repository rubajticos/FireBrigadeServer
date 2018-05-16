package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.CarEquipment;
import com.firebrigadeserver.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CarEquipmentRepository extends JpaRepository<CarEquipment, Integer> {

    List<CarEquipment> findByCar(Car car);

    List<CarEquipment> findByCarAndDateOfWithdrawalIsNull(Car car);

    List<CarEquipment> findByCarAndDateOfWithdrawalIsNotNull(Car car);

    CarEquipment findByEquipmentAndDateOfWithdrawalIsNull(Equipment equipment);

    boolean existsByCarAndEquipmentAndQtyAndDateOfPutAndDateOfWithdrawal(Car car, Equipment equipment, int qty, Date put, Date withdrawal);

}
