package com.example.messageproducer.Controller;

import com.example.messageproducer.Componenet.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

@Autowired
    private MessageProducer messageProducer;
@PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
    messageProducer.sendMessage(Long.valueOf(message));
    return ResponseEntity.ok("Message sent successfully");
}






}
