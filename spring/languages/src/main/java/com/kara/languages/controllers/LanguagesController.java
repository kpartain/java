package com.kara.languages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/languages")
public class LanguagesController {

	//table and add new form, "home"
	@RequestMapping("")
	public String showTableAndForm() {
		return "tableAndForm.jsp";
	}
	
	//post from languages, new Language persists
	@RequestMapping(value="/post-new", method=RequestMethod.POST)
	public String persistNewLanguage(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		//make a new language and get its id
		Long id = 1L; //get the actual ID from the DB
		String returnLocation = "redirect:/" + id;
		return returnLocation;
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
	public String persistNewLanguage(@RequestParam(value="id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
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
