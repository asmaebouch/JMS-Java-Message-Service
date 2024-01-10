package com.example.messageproducer.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class jacksonConfig {



    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
