package com.bkpw.projektkoncowy.controller;

import com.bkpw.projektkoncowy.dto.PositionDTO;
import com.bkpw.projektkoncowy.dto.UserDTO;
import com.bkpw.projektkoncowy.entity.Position;
import com.bkpw.projektkoncowy.entity.User;
import com.bkpw.projektkoncowy.service.DepartmentService;
import com.bkpw.projektkoncowy.service.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PositionController {

    @Autowired
    PositionService positionService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/position")
    @ResponseStatus(HttpStatus.CREATED)
    public Position create(@RequestBody @Valid PositionDTO positionDTO) {
        Position position= convertToEntity(positionDTO);
        position.setDepartment(departmentService.getOne(positionDTO.getDepartmentId()));
        return positionService.create(position);
    }

    @GetMapping("/positions")
    @ResponseStatus(HttpStatus.OK)
    public List<Position> getAll() {
        return positionService.getAll();
    }

    @GetMapping("position/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Position getOne(@PathVariable Long id) {
        return positionService.getOne(id);
    }

    @DeleteMapping("position/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        positionService.delete(id);
    }

    @PutMapping("position/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Position update(@PathVariable Long id,
                          @RequestBody @Valid Position position) {
        return positionService.update(position, id);
    }

    private Position convertToEntity(PositionDTO positionDTO)  {
        Position position = modelMapper.map(positionDTO, Position.class);
        return position;
    }

    private PositionDTO  entityToDTO(Position position){
        PositionDTO positionDTO=modelMapper.map(position,PositionDTO.class);
        return positionDTO;
    }

}
