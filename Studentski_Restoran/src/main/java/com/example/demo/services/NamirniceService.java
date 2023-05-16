package com.example.demo.services;

import com.example.demo.models.Namirnice;

public interface NamirniceService {
	
	Namirnice createNamirnice(Namirnice Namirnice);
	
	Namirnice updateNamirnice(Namirnice Namirnice);
	
	Iterable<Namirnice>getAllNamirnice();
	
	Namirnice getNamirnice(long id_Namirnice);
	
	void deleteNamirnice(long id);
	
}
