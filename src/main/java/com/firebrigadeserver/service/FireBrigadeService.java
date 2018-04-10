package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.User;
import com.firebrigadeserver.repositories.FireBrigadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireBrigadeService implements IFireBrigadeService {

    @Autowired
    private FireBrigadeRepository repository;

    @Override
    public List<FireBrigade> getAllFireBrigades() {
        return repository.findAll();
    }

    @Override
    public FireBrigade getFireBrigadeById(int fireBrigadeId) {
        return repository.findByIdFireBrigade(fireBrigadeId);
    }

    @Override
    public FireBrigade getFireBrigadeByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public boolean addFireBrigade(FireBrigade fireBrigade) {
        try {
            if (repository.existsByNameAndCityAndCommunityAndDistrictAndVoivodeship(fireBrigade.getName(), fireBrigade.getCity(),
                    fireBrigade.getCommunity(), fireBrigade.getDistrict(), fireBrigade.getVoivodeship())) {
                return false;
            } else {
                repository.save(fireBrigade);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public FireBrigade updateFireBrigade(FireBrigade fireBrigade) {
        FireBrigade updateFireBrigade = repository.findByIdFireBrigade(fireBrigade.getIdFireBrigade());
        updateFireBrigade.setName(fireBrigade.getName());
        updateFireBrigade.setCity(fireBrigade.getCity());
        updateFireBrigade.setCommunity(fireBrigade.getCommunity());
        updateFireBrigade.setDistrict(fireBrigade.getDistrict());
        updateFireBrigade.setVoivodeship(fireBrigade.getVoivodeship());
        updateFireBrigade.setKsrg(fireBrigade.isKsrg());
        return repository.save(updateFireBrigade);
    }

    @Override
    public void deleteFireBrigade(int fireBrigadeId) {
        repository.delete(fireBrigadeId);
    }
}
