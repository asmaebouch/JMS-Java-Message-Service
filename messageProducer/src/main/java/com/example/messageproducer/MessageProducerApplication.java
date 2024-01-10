package com.example.messageproducer;

import com.example.messageproducer.Repository.MessageRepository;
import com.example.messageproducer.entity.Msg;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MessageProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageProducerApplication.class, args);
	}
@Bean
	CommandLineRunner start(MessageRepository messageRepository){
		return args -> {
			messageRepository.save(new Msg(1L,"Monday"));
			messageRepository.save(new Msg(2L,"Tuesday"));
			messageRepository.save(new Msg(3L,"wednesday"));

		};
}
}
