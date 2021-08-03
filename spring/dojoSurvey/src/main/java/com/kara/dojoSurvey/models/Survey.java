package com.kara.dojoSurvey.models;

import java.util.ArrayList;

public class Survey {
	public String studentName;
	public String location;
	public String favoriteLanguage;
	public String comment;
	private static ArrayList<String> defaultLanguages = new ArrayList<String>() {{
		add("Java"); 
		add("Python");
		add("Swift");
		add("Javascript");
		add("HTML");
		add("CSS");
	}};
	private ArrayList<Survey> allSurveys;
	
	public Survey(String studentName, String location, String favoriteLanguage, String comment) {
		this.studentName = studentName;
		this.location = location;
		this.favoriteLanguage = favoriteLanguage;
		this.comment = comment;
		allSurveys.add(this);
	}
	
	public static ArrayList<String> getDefaultLanguages() {
		return defaultLanguages;
	}
}
