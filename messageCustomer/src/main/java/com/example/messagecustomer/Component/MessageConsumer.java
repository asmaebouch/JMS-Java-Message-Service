package com.example.messagecustomer.Component;

import com.example.messagecustomer.entity.Msg;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageConsumer {
    private final ObjectMapper objectMapper;

    public MessageConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @JmsListener(destination = "test")
    public void onMessage(@Payload String jsonMessage) {
        try {
            // Attempt to deserialize as a single Msg object
            Msg receivedMsg = objectMapper.readValue(jsonMessage, Msg.class);
            System.out.println("Received Msg: " + receivedMsg);

            // If the above fails, attempt to deserialize as a list of Msg objects
            if (receivedMsg == null) {
                List<Msg> receivedMsgList = objectMapper.readValue(jsonMessage, objectMapper.getTypeFactory().constructCollectionType(List.class, Msg.class));
                System.out.println("Received List<Msg>: " + receivedMsgList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
