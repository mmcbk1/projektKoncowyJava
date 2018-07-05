package com.bkpw.projektkoncowy.service;

import com.bkpw.projektkoncowy.entity.Message;
import com.bkpw.projektkoncowy.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements GenericService<Message> {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message create(Message message) {
        return null;
    }

    @Override
    public Message getOne(Long id) {
        return null;
    }

    @Override
    public Page<Message> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Message update(Message message, Long id) {
        return null;
    }
}
