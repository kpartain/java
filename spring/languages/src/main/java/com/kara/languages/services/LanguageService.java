package com.kara.languages.services;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kara.languages.models.Language;
import com.kara.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language languageToSave) {
		return languageRepository.save(languageToSave);
	}
	
	public Language findLanguageById(Integer id) {
		Optional<Language> objectBeforeCasting = languageRepository.findById(id);
		if(objectBeforeCasting.isPresent()) {
			return objectBeforeCasting.get();
		} else {
			System.out.println("Error in Service");
			return null;
		}
	}
	
	public void deleteById(Integer id) {
		languageRepository.deleteById(id);
	}
}
