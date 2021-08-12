package com.kara.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kara.languages.models.Language;
import com.kara.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguagesController {

	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String redirectToLanguages() {
		
		return "redirect:/languages";
	}
	//table and add new form, "home"
	@RequestMapping("")
	public String showTableAndForm(Model model, @ModelAttribute("language") Language language) {
		List<Language> allLanguages = languageService.allLanguages();
		model.addAttribute("allLanguages", allLanguages);
		return "tableAndForm.jsp";
	}
	
	//post from languages, new Language persists
	//?? How to get ID back to dynamically redirect to here 
	@RequestMapping(value ="", method=RequestMethod.POST)
	public String persistNewLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		//make a new language and get its id
		if(result.hasErrors()) {
			List<Language> allLanguages = languageService.allLanguages();
			model.addAttribute("allLanguages", allLanguages);
			return "tableAndForm.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
		
	}
	
	//edit language form page
	@RequestMapping("/{id}/edit")
	public String showEditForm(@PathVariable("id") Integer id, Model model) {
		//get the single Language object
		Language language = languageService.findLanguageById(id);
		//hand it to the form via model
		model.addAttribute("language", language);
		return "editForm.jsp";
	}
	
	//post from edit-language
	@RequestMapping(value="/{id}/edited", method=RequestMethod.PUT)
	public String updateExistingLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		//use setters to update the existing language
		if (result.hasErrors()) {
            return "editForm.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
	}
	
	//show page
	@RequestMapping("/{id}")
	public String showSingleLanguage(@PathVariable("id") Integer id, Model model) {
		//get the single Language object
		Language language = languageService.findLanguageById(id);
		//hand it to the page via model
		model.addAttribute("language", language);
		return "show.jsp";
	}
	
	//delete
	//post from edit-language
	@RequestMapping(value="delete/{id}")
	public String persistNewLanguage(@PathVariable("id") Integer id) {
		//delete by ID
		languageService.deleteById(id);
		//return to dashboard
		return "redirect:/languages";
	}
}
