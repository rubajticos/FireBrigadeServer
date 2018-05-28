package com.firebrigadeserver.service;

import com.firebrigadeserver.dto.additional.CarWithEquipment;
import com.firebrigadeserver.dto.additional.CarsAndFirefighters;
import com.firebrigadeserver.dto.additional.IncidentFull;
import com.firebrigadeserver.dto.mapper.CarMapper;
import com.firebrigadeserver.dto.mapper.EquipmentMapper;
import com.firebrigadeserver.dto.mapper.FirefighterMapper;
import com.firebrigadeserver.entity.*;
import com.firebrigadeserver.repositories.IncidentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentService implements IIncidentService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private FireBrigadeIncidentService fireBrigadeIncidentService;

    @Autowired
    private CarIncidentService carIncidentService;

    @Autowired
    private FireBrigadeService fireBrigadeService;

    @Autowired
    private FirefighterService firefighterService;

    @Autowired
    private FirefighterMapper firefighterMapper;

    @Autowired
    private CarService carService;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private CarEquipmentService carEquipmentService;

    @Autowired
    private EquipmentMapper equipmentMapper;


    @Override
    @Transactional
    public List<IncidentFull> getIncidentsByFireBrigade(FireBrigade fireBrigade) {
        List<Incident> incidents = incidentRepository.findByFireBrigades_fireBrigadeOrderByDateDesc(fireBrigade);
        List<IncidentFull> fullIncidents = new ArrayList<>();

        for (Incident inc : incidents) {
            List<CarIncident> cars = carIncidentService.getCarIncidentByIncident(inc);
            List<FirebrigadeIncident> firebrigades = fireBrigadeIncidentService.getFireBrigadeIncidentsForIncident(inc);

            IncidentFull fullDataIncident = new IncidentFull();
            fullDataIncident.setIncident(inc);
            fullDataIncident.setCars(cars);
            fullDataIncident.setFireBrigades(firebrigades);
            fullIncidents.add(fullDataIncident);
        }


        return fullIncidents;
    }

    @Override
    @Transactional
    public List<Incident> getIncidentsByCar(Car car) {
        return incidentRepository.findByCars_car(car);
    }

    @Override
    @Transactional
    public IncidentFull getIncidentById(int incidentId) {
        Incident incident = incidentRepository.findOne(incidentId);
        List<CarIncident> cars = carIncidentService.getCarIncidentByIncident(incident);
        List<FirebrigadeIncident> firebrigades = fireBrigadeIncidentService.getFireBrigadeIncidentsForIncident(incident);

        IncidentFull fullDataIncident = new IncidentFull();
        fullDataIncident.setIncident(incident);
        fullDataIncident.setCars(cars);
        fullDataIncident.setFireBrigades(firebrigades);

        return fullDataIncident;
    }

    @Override
    @Transactional
    public IncidentFull addIncident(IncidentFull incidentFull) {
        Incident candidateIncident = incidentFull.getIncident();
        List<CarIncident> candidateCars = incidentFull.getCars();
        List<FirebrigadeIncident> candidateFirebrigade = incidentFull.getFireBrigades();
        List<FirebrigadeIncident> clearFireBrigades = candidateIncident.getFireBrigades();
        clearFireBrigades.clear();
        candidateIncident.setFireBrigades(clearFireBrigades);
        List<CarIncident> candindateCars = incidentFull.getCars();
        List<CarIncident> clearCars = candidateIncident.getCars();
        clearCars.clear();
        candidateIncident.setCars(clearCars);


        candidateIncident = incidentRepository.save(candidateIncident);
        System.out.println("Po dodaniu zdarzenia");
        if (candidateIncident != null) {
            candidateCars = fillIncidentIntoCars(candidateCars, candidateIncident);
            candidateFirebrigade = fillIncidentIntoFireBrigades(candidateFirebrigade, candidateIncident);

            candidateCars = carIncidentService.addCarIncident(candidateCars);
            candidateFirebrigade = fireBrigadeIncidentService.addFireBrigadeIncident(candidateFirebrigade);

            candidateIncident.setCars(candidateCars);
            candidateIncident.setFireBrigades(candidateFirebrigade);

            Incident addedIncident = incidentRepository.save(candidateIncident);

            IncidentFull addedFullIncident = new IncidentFull();
            addedFullIncident.setIncident(addedIncident);
            addedFullIncident.setFireBrigades(addedIncident.getFireBrigades());
            addedFullIncident.setCars(addedIncident.getCars());

            return addedFullIncident;
        }

        return null;
    }

    private List<FirebrigadeIncident> fillIncidentIntoFireBrigades(List<FirebrigadeIncident> candidateFirebrigade, Incident candidateIncident) {
        List<FirebrigadeIncident> withCars = candidateFirebrigade;
        for (FirebrigadeIncident f : withCars) {
            f.setIncident(candidateIncident);
        }

        return withCars;
    }

    private List<CarIncident> fillIncidentIntoCars(List<CarIncident> candidateCars, Incident candidateIncident) {
        List<CarIncident> withCars = candidateCars;
        for (CarIncident c : withCars) {
            c.setIncident(candidateIncident);
        }

        return withCars;
    }

    @Override
    @Transactional
    public Incident updateIncident(Incident incident) {
        // TODO: 22/05/2018 aktualizacja zdarzenia
        return null;
    }

    @Override
    @Transactional
    public void deleteIncident(int incidentId) {
        // TODO: 22/05/2018 usuwanie zdarzenia
    }

    @Override
    @Transactional
    public CarsAndFirefighters getDataForPreparingIncident(int fireBrigadeId) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(fireBrigadeId);
        CarsAndFirefighters carsAndFirefighters = new CarsAndFirefighters();

        List<Firefighter> commanders = firefighterService.getCommanders(fireBrigade);
        List<Firefighter> drivers = firefighterService.getDrivers(fireBrigade);
        List<Firefighter> firefighters = firefighterService.getFirefightersByFirebrigade(fireBrigadeId);

        List<Car> cars = carService.getCarsByFireBrigade(fireBrigadeId);

        List<CarWithEquipment> carWithEquipments = prepareCarWithEquipment(cars);

        carsAndFirefighters.setCars(carWithEquipments);
        carsAndFirefighters.setCommanders(firefighterMapper.entityListToDtoList(commanders));
        carsAndFirefighters.setDrivers(firefighterMapper.entityListToDtoList(drivers));
        carsAndFirefighters.setFirefighters(firefighterMapper.entityListToDtoList(firefighters));

        return carsAndFirefighters;
    }

    private List<CarWithEquipment> prepareCarWithEquipment(List<Car> cars) {
        List<CarWithEquipment> carWithEquipments = new ArrayList<>();
        for (Car c : cars) {
            CarWithEquipment carWithEquipment = new CarWithEquipment();

            List<CarEquipment> carEquipments = carEquipmentService.getActiveCarEquipmentForCar(c.getId());

            List<Equipment> equipment = prepareEquipments(carEquipments);

            carWithEquipment.setCarDTO(carMapper.entityToDto(c));
            carWithEquipment.setEquipments(equipmentMapper.entityListToDtoList(equipment));
            carWithEquipments.add(carWithEquipment);

        }
        return carWithEquipments;
    }

    private List<Equipment> prepareEquipments(List<CarEquipment> carEquipments) {
        List<Equipment> equipmentList = new ArrayList<>();

        for (CarEquipment ce : carEquipments) {
            equipmentList.add(ce.getEquipment());
        }
        return equipmentList;
    }
}
