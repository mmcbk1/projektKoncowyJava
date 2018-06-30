package com.bkpw.projektkoncowy.repository;

import com.bkpw.projektkoncowy.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
