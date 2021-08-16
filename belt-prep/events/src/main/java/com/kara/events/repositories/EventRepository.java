package com.kara.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kara.events.models.Event;

@Repository
public interface EventRepository extends CrudRepository <Event, Long>{

}
