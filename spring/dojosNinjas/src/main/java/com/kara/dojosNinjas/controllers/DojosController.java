package com.kara.dojosNinjas.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kara.dojosNinjas.models.Dojo;
import com.kara.dojosNinjas.models.Ninja;
import com.kara.dojosNinjas.services.DojoService;


@Controller
@RequestMapping("/dojos")
public class DojosController {

	@Autowired
	private final DojoService dojoService;
	
	public DojosController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	//FORM
	@RequestMapping("/new")
	public String showForm() {
		return "newDojo.jsp";
	}
	
	//POST
	@RequestMapping(value="/new/post", method=RequestMethod.POST)
	public String persistNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		//make a new dojo 
		if(result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
		
	}
	
	//SHOW
	@RequestMapping("/{id}")
	public String showDojoAndItsNinjas(@PathVariable("id") Integer id, Model model) {
		//get the single object
		Dojo dojo = dojoService.findDojoById(id);
		//get the list of ninja objects just for ease
		List<Ninja> ninjasInDojo = dojo.getNinjas();
		//hand both to the page via model
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjasInDojo", ninjasInDojo);
		return "locationShow.jsp";
	}
	
}
