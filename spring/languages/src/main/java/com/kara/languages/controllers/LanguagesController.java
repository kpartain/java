package com.kara.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	//table and add new form, "home"
	@RequestMapping("")
	public String showTableAndForm(Model model) {
		List<Language> allLanguages = languageService.allLanguages();
		model.addAttribute("allLanguages", allLanguages);
		return "tableAndForm.jsp";
	}
	
	//post from languages, new Language persists
	//?? How to get ID back to dynamically redirect to here 
	@RequestMapping(value="/post-new", method=RequestMethod.POST)
	public String persistNewLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		//make a new language and get its id
		if(result.hasErrors()) {
			return "tableAndForm.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
		
	}
	
	//edit language form page
	@RequestMapping("/edit/{id}")
	public String showEditForm(Long id, Model model) {
		//get the single Language object
		//hand it to the form via model
		model.addAttribute("language", "LANGUAGEOBJECT");
		return "editForm.jsp";
	}
	
	//post from edit-language
	@RequestMapping(value="/post-edit", method=RequestMethod.POST)
	public String persistNewLanguage(@RequestParam(value="id") Integer id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		//make a new language and get its id
		
		String returnLocation = "redirect:/" + id;
		return returnLocation;
	}
	
	//show page
	@RequestMapping("/{id}")
	public String showSingleLanguage(Long id) {
		//get the single Language Object
		
		return "show.jsp";
	}
	
	//delete
	//post from edit-language
	@RequestMapping(value="/post-delete", method=RequestMethod.POST)
	public String persistNewLanguage(@RequestParam(value="id") Long id) {
		//delete by ID
		
		//return to dashboard
		return "redirect:/";
	}
}
