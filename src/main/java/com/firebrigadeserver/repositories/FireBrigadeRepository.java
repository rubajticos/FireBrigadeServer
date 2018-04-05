package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireBrigadeRepository extends JpaRepository<FireBrigade, Integer> {

    FireBrigade findByUser(User user);

    FireBrigade findByIdFireBrigade(int idFireBrigade);

    boolean existsByNameAndCityAndCommunityAndDistrictAndVoivodeship(String name, String city, String community, String district, String voivodeship);
}
