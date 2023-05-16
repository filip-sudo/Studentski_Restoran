package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Namirnice;
import com.example.demo.services.NamirniceService;

@Controller
public class NamirniceController {
	
	@Autowired
	 private NamirniceService service;
	
	@GetMapping(value="/namirnice")
	public String pocetakNamirnice(Model model) {
		
		ArrayList<Namirnice> popisNamirnica = (ArrayList)service.getAllNamirnice();
		model.addAttribute("listaNamirnica", popisNamirnica);
		
		return "Namirnicehtml";
	}
	
	@RequestMapping(value = "/novi", method = RequestMethod.GET)
	public String getNoviNamirnice(Model model) {
		
		Namirnice Namirnice = new Namirnice();
		model.addAttribute("Namirnice", Namirnice);
		
		return "novi_Namirnice";
	}
	
	@RequestMapping(value = "/novi", method = RequestMethod.POST)
		public String postNoviNamirnice(@ModelAttribute("Namirnice") Namirnice Namirnice) {
			service.createNamirnice(Namirnice);
			return "redirect:/namirnice";
	}
	
	@RequestMapping("/uredi/{id}")
	public ModelAndView urediNamirnice(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("uredi_namirnice");
		Namirnice namirnice = service.getNamirnice(id);
		mav.addObject("namirnice", namirnice);
		return mav;
	}

	
	@RequestMapping(value = "/uredi", method = RequestMethod.POST)
	public String snimiNamirnice(@ModelAttribute("Namirnice") Namirnice namirnice) {
		service.updateNamirnice(namirnice);
		return "redirect:/namirnice";
	}
	
	@RequestMapping("/brisi/{id}")
	public String brisanjeNamirnice(@PathVariable(name = "id") int id) {
	service.deleteNamirnice(id);
	return "redirect:/namirnice";
	}
	


}
