package com.example.messageproducer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Msg implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public Long id;
    public String msg;

}
