package controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.Namirnice;
import services.NamirniceService;

@Controller
@RequestMapping("/namirnice")
public class NamirniceController {
	
	@Autowired
	 private NamirniceService service;
	@RequestMapping("/")
	public String pocetakNamirnice(Model model) {
	ArrayList<Namirnice> popisNamirnica = (ArrayList)service.getAllNamirnice();
	model.addAttribute("listaNamirnica", popisNamirnica);
	return "pocetnaNamirnice";
	}
	@RequestMapping(value = "/namirnice", method = RequestMethod.GET)
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
	


}
