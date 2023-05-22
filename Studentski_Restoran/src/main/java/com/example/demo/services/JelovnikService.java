package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Jelovnik;

public interface JelovnikService {
	
	Jelovnik createJelovnik(Jelovnik Jelovnik);
	
	Jelovnik updateJelovnik(Jelovnik Jelovnik);
	
	Iterable<Jelovnik>getAllJelovnik();
	
	Jelovnik getJelovnik(long id_jelovnik);
	
	void deleteJelovnik(long id);
	
	List<Jelovnik> getByKeyword(String keyword);
	
	List<Jelovnik> getByKeywordMjesecni(String keyword);
	
	List<Jelovnik> getByKeywordTjedni(String keyword);
	
	List<Jelovnik> getByKeywordDnevni(String keyword);
	
}