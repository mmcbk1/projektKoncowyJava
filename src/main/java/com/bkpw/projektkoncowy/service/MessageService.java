package com.bkpw.projektkoncowy.service;

import com.bkpw.projektkoncowy.entity.Message;
import com.bkpw.projektkoncowy.entity.User;
import com.bkpw.projektkoncowy.exception.NotFoundException;
import com.bkpw.projektkoncowy.repository.MessageRepository;
import com.bkpw.projektkoncowy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService /*implements GenericService<Message>*/ {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    public List<Message> getAllUserMessageToAnotherUser(Long senderId,Long receiverId){
        return messageRepository.findBySender_IdAndReceiver_Id(senderId,receiverId);
    }

    public Message create(Long senderId,
                          Message message,
                          Long receiverId) {
        Optional<User> OptionalUserToUpdate = userRepository.findById(receiverId);
        if (!OptionalUserToUpdate.isPresent()) {
            throw new NotFoundException(String.format("User with id %s not found", receiverId));
        }
        message.setSender(userRepository.getOne(senderId));
        message.setReceiver(userRepository.getOne(receiverId));
        return messageRepository.save(message);
    }
}
