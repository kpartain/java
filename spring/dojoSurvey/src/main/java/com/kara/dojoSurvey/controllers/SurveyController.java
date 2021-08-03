package com.kara.dojoSurvey.controllers;

import com.kara.dojoSurvey.models.Survey;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SurveyController {
	
	private ArrayList<String> languages = Survey.getDefaultLanguages();
	
	@RequestMapping("/")
	public String renderForm(Model model) {
//		ArrayList<String> languages = Survey.getDefaultLanguages();
		System.out.println(languages);
		model.addAttribute("languages", languages);
		return "form.jsp";
	}
	
	 @RequestMapping(value="/survey-post", method=RequestMethod.POST)
	    public String login(@RequestParam(value="studentName") String studentName, @RequestParam(value="location") String location, @RequestParam(value="favoriteLanguage") int favoriteLanguage, @RequestParam(value="comment") String comment, final RedirectAttributes redirectAttrs) {
		 if(comment.isEmpty()) {
			 comment = "[student did not leave a comment]";
		 }
		 String selectedLanguage = languages.get(favoriteLanguage);
		 System.out.println(selectedLanguage);
		 Survey surveyObjectFromForm = new Survey(studentName, location, selectedLanguage, comment);
		 redirectAttrs.addFlashAttribute("name", surveyObjectFromForm.studentName);
		 redirectAttrs.addFlashAttribute("location", surveyObjectFromForm.location);
		 redirectAttrs.addFlashAttribute("favoriteLanguage", surveyObjectFromForm.favoriteLanguage);
		 redirectAttrs.addFlashAttribute("comment", surveyObjectFromForm.comment);
		 return "redirect:/result";
	 }
	 
	 @RequestMapping("/result")
	 public String renderSurvey() {
		 System.out.println(Survey.listOfSurveys());
		 return "result.jsp";
	 }
}
