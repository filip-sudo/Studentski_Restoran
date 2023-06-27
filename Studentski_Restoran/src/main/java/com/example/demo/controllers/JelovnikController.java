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

import com.example.demo.models.Jelovnik;
import com.example.demo.models.Meni;
import com.example.demo.services.JelovnikService;
import com.example.demo.services.MeniService;

import jakarta.validation.Valid;

@Controller
public class JelovnikController {
	
	@Autowired
	 private JelovnikService service;
	
	@Autowired
	private MeniService meniService;
	
	@GetMapping("/jelovnik")
	public String pocetakJelovnik(Model model, String keyword, String mjesecni, String tjedni, String dnevni) {
		
		if(keyword == null) {
		ArrayList<Jelovnik> popisJelovnik = (ArrayList)service.getAllJelovnik();
		model.addAttribute("listaJelovnik", popisJelovnik);
		}else {
			
			if(mjesecni == "mjesecni") {
				ArrayList<Jelovnik> popisJelovnik = (ArrayList)service.getByKeywordMjesecni(keyword);
				model.addAttribute("listaJelovnik", popisJelovnik);
			}
			if(tjedni == "tjedni") {
				ArrayList<Jelovnik> popisJelovnik = (ArrayList)service.getByKeywordTjedni(keyword);
				model.addAttribute("listaJelovnik", popisJelovnik);
			}
			if(dnevni == "dnevni") {
				ArrayList<Jelovnik> popisJelovnik = (ArrayList)service.getByKeywordDnevni(keyword);
				model.addAttribute("listaJelovnik", popisJelovnik);
			}else {
			
			
			ArrayList<Jelovnik> popisJelovnik = (ArrayList)service.getByKeyword(keyword);
			model.addAttribute("listaJelovnik", popisJelovnik);
		}}
		
		return "pocetna_Jelovnik";
	}
	
	@RequestMapping(value = "/jelovnik/novi", method = RequestMethod.GET)
	public String getNoviJelovnik(Model model) {
		
		Jelovnik Jelovnik = new Jelovnik();
		model.addAttribute("Jelovnik", Jelovnik);
		
		ArrayList<Meni> popisMeni = (ArrayList)meniService.getAllMeni();
		model.addAttribute("listaMeni", popisMeni);
		
		return "novi_Jelovnik";
	}
	
	@RequestMapping(value = "/jelovnik/novi", method = RequestMethod.POST)
		public String postNoviJelovnik(@Valid @ModelAttribute("Jelovnik") Jelovnik Jelovnik, BindingResult result, Model model) {
			
		if(result.hasErrors()) {
			
			ArrayList<Meni> popisMeni = (ArrayList)meniService.getAllMeni();
			model.addAttribute("listaMeni", popisMeni);
			
			return "novi_Jelovnik";
		}
			
			service.createJelovnik(Jelovnik);
			
			return "redirect:/jelovnik";
	}
	
	
	@RequestMapping("/jelovnik/uredi/{id}")
	public ModelAndView urediJelovnik(@PathVariable(name = "id") int id, Model model) {
		ModelAndView mav = new ModelAndView("uredi_Jelovnik");
		Jelovnik jelovnik = service.getJelovnik(id);
		mav.addObject("jelovnik", jelovnik);
		
		ArrayList<Meni> popisMeni = (ArrayList)meniService.getAllMeni();
		model.addAttribute("listaMeni", popisMeni);
		
		return mav;
	}

	
	@RequestMapping(value = "/jelovnik/uredi", method = RequestMethod.POST)
	public String snimiJelovnik(@ModelAttribute("Jelovnik") Jelovnik Jelovnik) {
		service.updateJelovnik(Jelovnik);
		return "redirect:/jelovnik";
	}
	
	@RequestMapping("/jelovnik/brisi/{id}")
	public String brisanjeJelovnik(@PathVariable(name = "id") int id) {
	service.deleteJelovnik(id);
	return "redirect:/jelovnik";
	}
	
}
