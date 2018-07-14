package com.bkpw.projektkoncowy.repository;

import com.bkpw.projektkoncowy.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);

    Page<User> findByNameContainingIgnoreCaseAndLastNameContainingIgnoreCaseAndEmailContainingIgnoreCaseAndPosition_Department_Company_NameContainingIgnoreCaseAndPosition_NameContainingIgnoreCase(
            @Param("name") String name,
            @Param("lastName")String lastName,
            @Param("email")String email,
            @Param("companyName")String companyName,
            @Param("positionName")String positionName,
            Pageable pageable
    );


}
