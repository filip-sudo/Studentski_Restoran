package com.example.demo.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.Jelovnik;
import com.example.demo.models.Meni;
import com.example.demo.services.JelovnikService;
import com.example.demo.services.MeniService;
import com.example.demo.services.PDFService;

import jakarta.servlet.http.HttpServletResponse;
@Controller
public class SearchController {
	
	String pojam = "";
	
	@Autowired
	MeniService meniService;
	
	@Autowired
	JelovnikService jelovnikService;
	
	@GetMapping("/search")
	public String pocetakMeni(Model model, String keyword) {

		ArrayList<Meni> popisMeni = (ArrayList)meniService.getByKeyword(keyword);
		model.addAttribute("listaMeni", popisMeni);
		
		ArrayList<Jelovnik> popisJelovnik = (ArrayList)jelovnikService.getByKeyword(keyword);
		model.addAttribute("listaJelovnik", popisJelovnik);
		
		pojam = keyword;

		return "pocetna_Search";
	}
	
	private final PDFService pdfService;
	
	public SearchController(PDFService pdfService) {
		this.pdfService = pdfService;
	}
	
	@GetMapping("/search/pdf")
	public void exportToPDF(HttpServletResponse response, String keyword) throws IOException{
		
		keyword = pojam;
		
		List<Meni> popisMeni = (List<Meni>)meniService.getByKeyword(keyword);
		
		List<Jelovnik> popisJelovnik = (List<Jelovnik>)jelovnikService.getByKeyword(keyword);
		
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date(0));
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		this.pdfService.export(response, popisMeni, popisJelovnik);
		
	}

}
