package com.bkpw.projektkoncowy.service;

import com.bkpw.projektkoncowy.entity.User;
import com.bkpw.projektkoncowy.exception.NotFoundException;
import com.bkpw.projektkoncowy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements GenericService<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getOne(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new NotFoundException(String.format("User with id %s not found", id));
        }

        return user.get();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user, Long id) {
        Optional<User> OptionalUserToUpdate = userRepository.findById(id);
        if (!OptionalUserToUpdate.isPresent()) {
            throw new NotFoundException(String.format("User with id %s not found", id));
        }
        user.setId(id);
        return userRepository.save(user);
    }


}
