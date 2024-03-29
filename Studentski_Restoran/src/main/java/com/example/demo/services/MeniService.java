package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Meni;

public interface MeniService {
	
	Meni createMeni(Meni Meni);
	
	Meni updateMeni(Meni Meni);
	
	Iterable<Meni>getAllMeni();
	
	Meni getMeni(long id_meni);
	
	void deleteMeni(long id);

	List<Meni> getByKeyword(String keyword);
	
	
	

}
