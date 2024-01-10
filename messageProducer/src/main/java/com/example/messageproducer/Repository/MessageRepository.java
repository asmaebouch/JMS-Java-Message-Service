package com.example.messageproducer.Repository;

import com.example.messageproducer.entity.Msg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Msg,Long>{
    @RestResource(path="findById")
    Optional<Msg> findById(@Param("id") Long id);
}
