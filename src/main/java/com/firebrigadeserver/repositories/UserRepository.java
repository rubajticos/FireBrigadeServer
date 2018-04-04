package com.firebrigadeserver.repositories;

import com.firebrigadeserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByUserId(int userId);

    boolean existsByUsername(String username);
}
