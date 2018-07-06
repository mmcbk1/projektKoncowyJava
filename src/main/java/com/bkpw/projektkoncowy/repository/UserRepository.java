package com.bkpw.projektkoncowy.repository;

import com.bkpw.projektkoncowy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByName(String name);
}
