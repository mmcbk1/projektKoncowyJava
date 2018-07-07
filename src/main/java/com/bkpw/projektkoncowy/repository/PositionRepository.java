package com.bkpw.projektkoncowy.repository;

import com.bkpw.projektkoncowy.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
