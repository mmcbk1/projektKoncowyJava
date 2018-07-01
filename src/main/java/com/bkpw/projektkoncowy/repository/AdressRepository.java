package com.bkpw.projektkoncowy.repository;

import com.bkpw.projektkoncowy.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Address,Long> {
}
