package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Meni;
import com.example.demo.services.MeniService;

import jakarta.validation.Valid;

@Controller
public class MeniController {
	
	@Autowired
	 private MeniService service;
	
	@GetMapping("/meni")
	public String pocetakMeni(Model model, String keyword) {
		
		if(keyword==null) {
		ArrayList<Meni> popisMeni = (ArrayList)service.getAllMeni();
		model.addAttribute("listaMeni", popisMeni);
		}else {
			ArrayList<Meni> popisMeni = (ArrayList)service.getByKeyword(keyword);
			model.addAttribute("listaMeni", popisMeni);
		}
		
		return "pocetna_Meni";
	}
	
	@RequestMapping(value = "/meni/novi", method = RequestMethod.GET)
	public String getNoviMeni(Model model) {
		
		Meni Meni = new Meni();
		model.addAttribute("Meni", Meni);
		
		return "novi_Meni";
	}
	
	@RequestMapping(value = "/meni/novi", method = RequestMethod.POST)
		public String postNoviMeni(@Valid @ModelAttribute("Meni") Meni Meni, BindingResult result) {
			if(result.hasErrors()) {
				return "novi_Meni";
			}
		
			service.createMeni(Meni);
			return "redirect:/meni";
	}
	
	@RequestMapping("/meni/uredi/{id}")
	public ModelAndView urediMeni(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("uredi_Meni");
		Meni meni = service.getMeni(id);
		mav.addObject("meni", meni);
		return mav;
	}

	
	@RequestMapping(value = "/meni/uredi", method = RequestMethod.POST)
	public String snimiMeni(@ModelAttribute("Meni") Meni Meni) {

		service.updateMeni(Meni);
		return "redirect:/meni";
	}
	
	@RequestMapping("/meni/brisi/{id}")
	public String brisanjeMeni(@PathVariable(name = "id") int id) {
	service.deleteMeni(id);
	return "redirect:/meni";
	}

}
