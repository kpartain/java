package com.kara.displayDate.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Date;
import java.text.SimpleDateFormat;


@Controller 
public class TimeController {
	@RequestMapping("/")
	public String twoLinks() {
		return "demo.jsp";
	}
	
	@RequestMapping("/date")
	public String theDate(Model model) {
		Date instant = new Date();
		//Saturday, the 22 of January, 2028
        SimpleDateFormat sdf = new SimpleDateFormat( "EEEEE', the 'dd' of' MMMMM', 'yyyy" );
        String thisdate = sdf.format( instant );
		model.addAttribute("dateOrTime", thisdate);
		model.addAttribute("word", "date");
		model.addAttribute("color", "blue");
		return "link.jsp";
	}
	
	@RequestMapping("/time")
	public String theTime(Model model) {
		Date instant = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat( "hh:mm a" );
        String time = sdf.format( instant );
		model.addAttribute("dateOrTime", time);
		model.addAttribute("word", "time");
		model.addAttribute("color", "green");
		return "link.jsp";
	}

}
