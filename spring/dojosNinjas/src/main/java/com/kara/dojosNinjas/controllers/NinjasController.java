package com.kara.dojosNinjas.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kara.dojosNinjas.models.Dojo;
import com.kara.dojosNinjas.models.Ninja;
import com.kara.dojosNinjas.services.DojoService;
import com.kara.dojosNinjas.services.NinjaService;


@Controller
@RequestMapping("/ninjas")
public class NinjasController {
	
	@Autowired
	private final NinjaService ninjaService;
	
	@Autowired
	private final DojoService dojoService;
	
	public NinjasController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	//FORM
	//FORM
	@RequestMapping("/new")
	public String showForm(Model model) {
		List<Dojo> listOfDojos = dojoService.findAll();
		model.addAttribute("listOfDojos", listOfDojos);
		return "newNinja.jsp";
	}
	
	//POST
	@RequestMapping(value="/new/post", method=RequestMethod.POST)
	public String persistNewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		//make a new 
		if(result.hasErrors()) {
			return "newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
