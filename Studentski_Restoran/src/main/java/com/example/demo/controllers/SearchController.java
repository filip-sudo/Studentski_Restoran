package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.Jelovnik;
import com.example.demo.models.Meni;
import com.example.demo.models.Namirnice;
import com.example.demo.services.JelovnikService;
import com.example.demo.services.MeniService;
import com.example.demo.services.NamirniceService;

@Controller
public class SearchController {
	
	@Autowired
	MeniService meniService;
	
	@Autowired
	NamirniceService namirniceService;
	
	@Autowired
	JelovnikService jelovnikService;
	
	@GetMapping("/search")
	public String pocetakMeni(Model model, String keyword) {

		ArrayList<Meni> popisMeni = (ArrayList)meniService.getByKeyword(keyword);
		model.addAttribute("listaMeni", popisMeni);
		
		ArrayList<Jelovnik> popisJelovnik = (ArrayList)jelovnikService.getByKeyword(keyword);
		model.addAttribute("listaJelovnik", popisJelovnik);
		
		ArrayList<Namirnice> popisNamirnica = (ArrayList)namirniceService.getByKeyword(keyword);
		model.addAttribute("listaNamirnica", popisNamirnica);
		
		return "pocetna_Search";
	}

}
