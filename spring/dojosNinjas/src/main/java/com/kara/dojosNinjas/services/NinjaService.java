package com.kara.dojosNinjas.services;
import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kara.dojosNinjas.models.Ninja;
import com.kara.dojosNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	public void createNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
		
	}

}
