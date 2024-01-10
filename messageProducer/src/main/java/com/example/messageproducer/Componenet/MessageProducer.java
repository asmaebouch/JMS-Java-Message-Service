package com.example.messageproducer.Componenet;

import com.example.messageproducer.Repository.MessageRepository;
import com.example.messageproducer.entity.Msg;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(Long id) {
        //fetch the message from the repository
        Msg message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message with ID 1 not found"));

        try {
            String jsonMessage = objectMapper.writeValueAsString(message);
            jmsTemplate.convertAndSend("test", jsonMessage);
            System.out.print(
                    "Sent Json message ::" + message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
