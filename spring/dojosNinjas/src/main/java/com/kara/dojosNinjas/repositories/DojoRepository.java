package com.kara.dojosNinjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kara.dojosNinjas.models.Dojo;

import java.util.List;

public interface DojoRepository extends CrudRepository<Dojo, Integer>{

}
