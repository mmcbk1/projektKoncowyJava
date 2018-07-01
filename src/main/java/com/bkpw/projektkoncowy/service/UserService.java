package com.bkpw.projektkoncowy.service;

import com.bkpw.projektkoncowy.entity.User;
import com.bkpw.projektkoncowy.exception.NotFoundException;
import com.bkpw.projektkoncowy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<User> getAll() {
        return userRepository.findAll();
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
        User userToUpdate = OptionalUserToUpdate.get();

        updateAllData(user, userToUpdate);

        return userRepository.save(userToUpdate);
    }

    private void updateAllData(User user, User userToUpdate) {
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setBirthDate(user.getBirthDate());
        userToUpdate.setGender(user.getGender());
        userToUpdate.setHireDate(user.getHireDate());
        userToUpdate.setPosition(user.getPosition());
        userToUpdate.setSalary(user.getSalary());
        userToUpdate.setPassword(user.getPassword());
    }
}
