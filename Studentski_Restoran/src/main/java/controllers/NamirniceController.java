package controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import models.Namirnice;
import services.NamirniceService;

@Controller
@RequestMapping("/namirnice")
public class NamirniceController {
	
	@Autowired
	 private NamirniceService service;
	
	@GetMapping("/")
	public String pocetakNamirnice(Model model) {
		
		ArrayList<Namirnice> popisNamirnica = (ArrayList)service.getAllNamirnice();
		model.addAttribute("listaNamirnica", popisNamirnica);
		
		return "Namirnice";
	}
	
	@GetMapping("/novi")
	public String getNoviNamirnice(Model model) {
		
		Namirnice Namirnice = new Namirnice();
		model.addAttribute("Namirnice", Namirnice);
		
		return "novi_Namirnice";
	}
	
	@PostMapping("/novi")
		public String postNoviNamirnice(@ModelAttribute("Namirnice") Namirnice Namirnice) {
			service.createNamirnice(Namirnice);
			return "redirect:/namirnice";
	}
	
	@GetMapping("/uredi/{id}")
	public ModelAndView urediNamirnice(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("uredi_namirnice");
		Namirnice namirnice = service.getNamirnice(id);
		mav.addObject("namirnice", namirnice);
		return mav;
	}

	
	@PostMapping("/uredi")
	public String snimiNamirnice(@ModelAttribute("Namirnice") Namirnice namirnice) {
		service.updateNamirnice(namirnice);
		return "redirect:/namirnice";
	}
	
	@GetMapping("/brisi/{id}")
	public String brisanjeNamirnice(@PathVariable(name = "id") int id) {
	service.deleteNamirnice(id);
	return "redirect:/namirnice";
	}
	


}
