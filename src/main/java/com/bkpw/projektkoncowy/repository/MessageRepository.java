package com.bkpw.projektkoncowy.repository;

import com.bkpw.projektkoncowy.entity.Message;
import com.bkpw.projektkoncowy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

//List<Message> findBySenderAndReceiverOrderByCreated_atAsc (Long sender,Long receiver);

    List<Message> findBySender_IdAndReceiver_Id (Long idSender, Long idReceiver);


}
