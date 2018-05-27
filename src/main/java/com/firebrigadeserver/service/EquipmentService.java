package com.firebrigadeserver.service;

import com.firebrigadeserver.dto.additional.CarEquipmentWithAllCars;
import com.firebrigadeserver.dto.additional.EquipmentAdditional;
import com.firebrigadeserver.dto.mapper.CarEquipmentMapper;
import com.firebrigadeserver.dto.mapper.CarMapper;
import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.CarEquipment;
import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService implements IEquipmentService {

    @Autowired
    private EquipmentRepository repository;

    @Autowired
    private FireBrigadeService fireBrigadeService;

    @Autowired
    private CarEquipmentService carEquipmentService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private CarService carService;

    @Autowired
    private CarEquipmentMapper carEquipmentMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Equipment> getAllEquipment() {
        return repository.findAll();
    }

    @Override
    public List<Equipment> getEquipmentsByFireBrigade(int fireBrigadeId) {
        FireBrigade fb = fireBrigadeService.getFireBrigadeById(fireBrigadeId);
        return repository.findByFireBrigadeOrderByEquipmentOnTheCar_CarAscNameAsc(fb);
    }

    @Override
    public Equipment getEquipmentById(int equipmentId) {
        return repository.findOne(equipmentId);
    }

    @Override
    public Equipment addEquipment(Equipment equipment) {
        return repository.save(equipment);
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        Equipment updateEquipment = repository.findOne(equipment.getId());
        updateEquipment.setName(equipment.getName());
        updateEquipment.setType(equipment.getType());
        updateEquipment.setSubtype(equipment.getSubtype());
        return repository.save(updateEquipment);
    }

    @Override
    public void deleteEquipment(int eqiupmentId) {
        repository.delete(eqiupmentId);
    }

    @Override
    public List<EquipmentAdditional> getActiveEquipmentsByFireBrigadeWithCarNames(int fireBrigadeId) {
        List<Equipment> equipmentList = getEquipmentsByFireBrigade(fireBrigadeId);
        List<EquipmentAdditional> equipmentAdditionalList = new ArrayList<>();
        for (Equipment eq : equipmentList) {
            CarEquipment carEquipment = carEquipmentService.getActiveCarEquipmentForEquipment(eq.getId());
            if (carEquipment != null) {
                EquipmentAdditional equipmentAdditional = new EquipmentAdditional();
                equipmentAdditional.setId(carEquipment.getEquipment().getId());
                equipmentAdditional.setName(carEquipment.getEquipment().getName());
                equipmentAdditional.setType(carEquipment.getEquipment().getType());
                equipmentAdditional.setSubtype(carEquipment.getEquipment().getSubtype());
                equipmentAdditional.setCarName(carEquipment.getCar().getModel());
                equipmentAdditionalList.add(equipmentAdditional);
            } else {
                EquipmentAdditional equipmentAdditional = new EquipmentAdditional();
                equipmentAdditional.setId(eq.getId());
                equipmentAdditional.setName(eq.getName());
                equipmentAdditional.setType(eq.getType());
                equipmentAdditional.setSubtype(eq.getSubtype());
                equipmentAdditional.setCarName(null);
                equipmentAdditionalList.add(equipmentAdditional);
            }
        }

        return equipmentAdditionalList;
    }

    @Override
    @Transactional
    public CarEquipmentWithAllCars getActiveEquipmentAndAllCars(int equipmentId, int fireBrigadeId) {
        CarEquipment carEquipment = carEquipmentService.getActiveCarEquipmentForEquipment(equipmentId);
        Equipment equipment = equipmentService.getEquipmentById(equipmentId);
        List<Car> cars = carService.getCarsByFireBrigade(fireBrigadeId);

        CarEquipmentWithAllCars carEquipmentWithAllCars = new CarEquipmentWithAllCars();
        if (carEquipment != null) {
            carEquipmentWithAllCars.setCarEquipment(carEquipmentMapper.entityToDto(carEquipment));
        } else {
            CarEquipment emptyCarEquipment = new CarEquipment();
            emptyCarEquipment.setEquipment(equipment);
            carEquipmentWithAllCars.setCarEquipment(carEquipmentMapper.entityToDto(emptyCarEquipment));
        }
        carEquipmentWithAllCars.setAllCars(carMapper.entityListToDtoList(cars));

        return carEquipmentWithAllCars;
    }
}
