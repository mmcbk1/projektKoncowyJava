package com.bkpw.projektkoncowy.repository;

import com.bkpw.projektkoncowy.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);

    Page<User> findByNameContainingIgnoreCaseAndLastNameContainingIgnoreCaseAndEmailContainingIgnoreCaseAndPosition_Department_Company_NameAndPosition_NameContainingIgnoreCase(
            String name,
            String lastName,
            String email,
            String companyName,
            String positionName,
            Pageable pageable
    );
}
