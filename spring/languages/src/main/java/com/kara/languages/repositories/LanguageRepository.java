package com.kara.languages.repositories;

import java.util.List;
import com.kara.languages.models.Language;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer>{
	List<Language> findAll();
	Language findAllById(Integer id);
	List<Language> findByNameContaining(String search);
	//delete
	void deleteById(Integer id);
}
