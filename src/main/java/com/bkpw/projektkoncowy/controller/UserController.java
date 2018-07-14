package com.bkpw.projektkoncowy.controller;

import com.bkpw.projektkoncowy.dto.*;
import com.bkpw.projektkoncowy.entity.User;
import com.bkpw.projektkoncowy.exception.PasswordException;
import com.bkpw.projektkoncowy.repository.PositionRepository;
import com.bkpw.projektkoncowy.repository.UserRepository;
import com.bkpw.projektkoncowy.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Valid UserDTO userDTO,
                       BindingResult bindingResult){
        User user=convertToEntity(userDTO);
        user.setPosition(positionRepository.getOne(userDTO.getPositionId()));

        if (!userDTO.getPassword().equals(userDTO.getRepeatPassword())) {
            throw new PasswordException(String.format("Passwords are not the same"));
        }
        return userService.create(user,bindingResult);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Page<User> getAll(Pageable pageable){
        return userService.getAll(pageable);
    }


    @GetMapping("/users/search")
    @ResponseStatus(HttpStatus.OK)
    public PageImpl<SearchUserDTO> search(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "lastName", required = false, defaultValue = "") String lastName,
            @RequestParam(value = "email", required = false, defaultValue = "") String email,
            @RequestParam(value = "companyName", required = false, defaultValue = "") String companyName,
            @RequestParam(value = "positionName", required = false, defaultValue = "") String positionName,
            Pageable pageable) {

        Page<User> result=userService.search(name,lastName,email,companyName,positionName,pageable);
        int totalElements = (int) result.getTotalElements();

        return new PageImpl<>(result
                .stream()
                .map(user -> new SearchUserDTO(
                        user.getId(),
                        user.getName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPosition().getDepartment().getCompany().getName(),
                        user.getPosition().getDepartment().getCompany().getId(),
                        user.getPosition().getName()
                ))
                .collect(Collectors.toList()), pageable, totalElements);
    }



    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDTO getOne(@PathVariable Long id){
        User user=userService.getOne(id);

        UserDetailsDTO userDetailsDTO= modelMapper.map(user,UserDetailsDTO.class);
     //   userDetailsDTO.getDepartmentDTO().;
        return userDetailsDTO;
    }

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable Long id,
                       @RequestBody @Valid UserDTO userDTO,
                       BindingResult bindingResult){
        User user=convertToEntity(userDTO);
        return userService.update(user,id,bindingResult);
    }

    private User convertToEntity(UserDTO userDTO)  {
        User user = modelMapper.map(userDTO, User.class);
        user.toString();
        return user;
    }

    private UserDTO  entityToDTO(User user){
        UserDTO userDTO=modelMapper.map(user,UserDTO.class);
        return userDTO;
    }
}
