package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Meni;
import com.example.demo.models.Namirnice;

public interface NamirniceService {
	
	Namirnice createNamirnice(Namirnice Namirnice);
	
	Namirnice updateNamirnice(Namirnice Namirnice);
	
	Iterable<Namirnice>getAllNamirnice();
	
	Namirnice getNamirnice(long id_Namirnice);
	
	void deleteNamirnice(long id);
	
	List<Namirnice> getByKeyword(String keyword);
	
}
