package com.kara.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kara.events.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}
