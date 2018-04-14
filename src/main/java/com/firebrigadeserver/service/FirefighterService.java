package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.Firefighter;
import com.firebrigadeserver.repositories.FirefighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirefighterService implements IFirefighterService {

    @Autowired
    private FirefighterRepository repository;

    @Override
    public List<Firefighter> getAllFirefighters() {
        return repository.findAll();
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
        updateFirefighter.setFireBrigade(firefighter.getFireBrigade());
        updateFirefighter.setTrainings(firefighter.getTrainings());
        return repository.save(updateFirefighter);
    }

    @Override
    public void deleteFirefighter(int firefighterId) {
        repository.delete(firefighterId);
    }
}
