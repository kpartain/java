package com.kara.dojosNinjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kara.dojosNinjas.models.Ninja;

import java.util.List;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Integer>{


}
