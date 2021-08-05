package com.kara.dojosNinjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kara.dojosNinjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Integer>{

	Dojo findDojoById(Integer id);

}
