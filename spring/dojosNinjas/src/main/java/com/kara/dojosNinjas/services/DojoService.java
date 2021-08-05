package com.kara.dojosNinjas.services;
import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kara.dojosNinjas.models.Dojo;
import com.kara.dojosNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	public void createDojo(Dojo dojo) {
		dojoRepository.save(dojo);
		
	}

	public Dojo findDojoById(Integer id) {
		Optional<Dojo> thisDojo = dojoRepository.findById(id);
		if(thisDojo.isPresent()) {
			return thisDojo.get();
		} else {
			System.out.println("Error in Service");
			return null;
		}
	}

	public List<Dojo> findAll() {
		return (List<Dojo>) dojoRepository.findAll();
	}

}
