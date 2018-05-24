package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.CarIncident;
import com.firebrigadeserver.repositories.CarIncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarIncidentService implements ICarIncidentService {

    @Autowired
    private CarIncidentRepository carIncidentRepository;

    @Override
    @Transactional
    public CarIncident getCarIncidentById(int carIncidentId) {
        return carIncidentRepository.findOne(carIncidentId);
    }

    @Override
    @Transactional
    public CarIncident addCarIncident(CarIncident carIncident) {
        if (!carIncidentRepository.existsByCarAndIncidentAndDriverAndCommander(carIncident.getCar(), carIncident.getIncident(), carIncident.getDriver(), carIncident.getCommander())) {
            carIncidentRepository.save(carIncident);
        }

        return null;
    }

    @Override
    public List<CarIncident> addCarIncident(List<CarIncident> carIncidents) {
        for (CarIncident carIncident : carIncidents) {
            if (carIncidentRepository.existsByCarAndIncidentAndDriverAndCommander(carIncident.getCar(), carIncident.getIncident(), carIncident.getDriver(), carIncident.getCommander())) {
                return null;
            }
        }

        return carIncidentRepository.save(carIncidents);
    }

    @Override
    @Transactional
    public CarIncident updateCarIncident(CarIncident carIncident) {
        CarIncident toUpdate = carIncidentRepository.findOne(carIncident.getIdCarIncident());
        toUpdate.setDriver(carIncident.getDriver());
        toUpdate.setCommander(carIncident.getCommander());
        toUpdate.setDateTimeOfDeparture(carIncident.getDateTimeOfDeparture());
        toUpdate.setDateTimeOfReturn(carIncident.getDateTimeOfReturn());
        toUpdate.setFirefighters(carIncident.getFirefighters());
        toUpdate.setUsedEquipments(carIncident.getUsedEquipments());
        return carIncidentRepository.save(toUpdate);
    }

    @Override
    @Transactional
    public void deleteCarIncident(int carIncidentId) {
        carIncidentRepository.delete(carIncidentId);
    }
}
