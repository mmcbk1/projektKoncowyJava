package com.bkpw.projektkoncowy.repository;

import com.bkpw.projektkoncowy.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    boolean existsByName(String name);

    Page<Department>
    findByNameContainingIgnoreCaseAndShortNameContainingIgnoreCaseAndCompany_NameContainingIgnoreCase(
            @Param("name") String name,
            @Param("shortName") String shortName,
            @Param("companyName") String company,
            Pageable pageable);


}
