package com.bkpw.projektkoncowy.service;

import com.bkpw.projektkoncowy.entity.Company;
import com.bkpw.projektkoncowy.entity.Position;
import com.bkpw.projektkoncowy.exception.NotFoundException;
import com.bkpw.projektkoncowy.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;


@Service
public class PositionService{

    @Autowired
    PositionRepository positionRepository;

    public Position create(Position position) {
        return positionRepository.save(position);
    }

        public Position getOne(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        if (!position.isPresent()) {
            throw new NotFoundException(String.format("Position with id %s not found", id));
        }

        return position.get();
    }


    public List<Position> getAll() {
        return positionRepository.findAll();
    }


    public void delete(Long id) {
        if (!positionRepository.existsById(id)) {
            throw new NotFoundException(String.format("Position with id %s not found", id));
        }
        positionRepository.deleteById(id);

    }


    public Position update(Position position, Long id) {
        Optional<Position> OptionalPositionToUpdate = positionRepository.findById(id);
        if (!OptionalPositionToUpdate.isPresent()) {
            throw new NotFoundException(String.format("Position with id %s not found", id));
        }
        position.setId(id);
        return positionRepository.save(position);
    }
}
