package com.bkpw.projektkoncowy.controller;

import com.bkpw.projektkoncowy.entity.Message;
import com.bkpw.projektkoncowy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;


 /*   @PostMapping("/message/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Message create(@RequestBody @Valid Message message,
                          @PathVariable("id") Long receiverId) {

        return messageService.create(senderId, message, receiverId);
    }

    @GetMapping("/message/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Message> getAll(@PathVariable Long receiverId) {

        return messageService.getAllUserMessageToAnotherUser(senderId, receiverId);
    }

*/
}
