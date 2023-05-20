package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping(value="/")
	public String Pocetna() {
		
		return "Pocetna";
	}
	
}