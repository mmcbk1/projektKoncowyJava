package com.bkpw.projektkoncowy.service;

import com.bkpw.projektkoncowy.entity.Message;
import com.bkpw.projektkoncowy.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService /*implements GenericService<Message>*/ {

    @Autowired
    MessageRepository messageRepository;


    public Message create(Message message) {
        return null;
    }


    public Message getOne(Long id) {
        return null;
    }


    public Page<Message> getAll(Pageable pageable) {
        return null;
    }


    public void delete(Long id) {    }


    public Message update(Message message, Long id) {
        return null;
    }
}
