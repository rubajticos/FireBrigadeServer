package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.entity.Training;
import com.firebrigadeserver.repositories.FireBrigadeRepository;
import com.firebrigadeserver.repositories.FirefighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirefighterService implements IFirefighterService {

    @Autowired
    private FirefighterRepository repository;

    @Autowired
    private FireBrigadeRepository fireBrigadeRepository;

    @Autowired
    private TrainingService trainingService;

    @Override
    public List<Firefighter> getAllFirefighters() {
        return repository.findAll();
    }

    @Override
    public List<Firefighter> getFirefightersByFirebrigade(int firebrigadeId) {
        FireBrigade fb = fireBrigadeRepository.findByIdFireBrigade(firebrigadeId);
        return repository.findByFireBrigadeOrderByLastNameAscNameAsc(fb);
    }

    @Override
    public Firefighter getFireFighterById(int firefighterId) {
        return repository.findByIdFirefighter(firefighterId);
    }

    @Override
    public Firefighter getFireFighterByFirebrigadeAndNameAndLastName(FireBrigade firebrigade, String name, String lastname) {
        return repository.findByFireBrigadeAndNameAndLastName(firebrigade, name, lastname);
    }


    @Override
    public Firefighter addFirefighter(Firefighter firefighter) {
        try {
            if (repository.existsByNameAndLastNameAndBirthday(firefighter.getName(), firefighter.getLastName(), firefighter.getBirthday())) {
                return null;
            } else {
                return repository.save(firefighter);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Firefighter updateFirefighter(Firefighter firefighter) {
        Firefighter updateFirefighter = repository.findByIdFirefighter(firefighter.getIdFirefighter());
        updateFirefighter.setName(firefighter.getName());
        updateFirefighter.setLastName(firefighter.getLastName());
        updateFirefighter.setBirthday(firefighter.getBirthday());
        updateFirefighter.setExpiryMedicalTest(firefighter.getExpiryMedicalTest());
        updateFirefighter.setTrainings(firefighter.getTrainings());
        return repository.save(updateFirefighter);
    }

    @Override
    public void deleteFirefighter(int firefighterId) {
        repository.delete(firefighterId);
    }

    @Override
    public List<Firefighter> getCommanders(FireBrigade fireBrigade) {
        Training commanderTraining = trainingService.getTrainingByName("Szkolenie dowódców");
        return repository.findByTrainings_training(commanderTraining);
    }

    @Override
    public List<Firefighter> getDrivers(FireBrigade fireBrigade) {
        Training driverTraining = trainingService.getTrainingByName("Szkolenie kierowców");
        return repository.findByTrainings_training(driverTraining);
    }
}
