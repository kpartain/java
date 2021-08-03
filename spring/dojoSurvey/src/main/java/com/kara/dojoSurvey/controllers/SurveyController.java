package com.kara.dojoSurvey.controllers;

import com.kara.dojoSurvey.models.Survey;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SurveyController {

	@RequestMapping("/")
	public String renderForm(Model model) {
		ArrayList<String> languages = Survey.getDefaultLanguages();
		System.out.println(languages);
		model.addAttribute("languages", languages);
		return "form.jsp";
	}
}
