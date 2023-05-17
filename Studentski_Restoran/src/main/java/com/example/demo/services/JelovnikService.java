package com.example.demo.services;

import com.example.demo.models.Jelovnik;

public interface JelovnikService {
	
	Jelovnik createJelovnik(Jelovnik Jelovnik);
	
	Jelovnik updateJelovnik(Jelovnik Jelovnik);
	
	Iterable<Jelovnik>getAllJelovnik();
	
	Jelovnik getJelovnik(long id_jelovnik);
	
	void deleteJelovnik(long id);
	

}