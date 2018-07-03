package com.bkpw.projektkoncowy.controller;

import com.bkpw.projektkoncowy.entity.User;
import com.bkpw.projektkoncowy.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Page<User> getAll(Pageable pageable){
        return userService.getAll(pageable);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getOne(@PathVariable Long id){
        return userService.getOne(id);
    }

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable Long id,
                       @RequestBody User user){
        return userService.update(user,id);
    }
}
