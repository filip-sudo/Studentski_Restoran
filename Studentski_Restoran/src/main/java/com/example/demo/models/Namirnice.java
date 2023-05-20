package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Namirnice")
public class Namirnice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Namirnice;
	
	@Column
	private String naziv;
	

	
	
	
	public long getId_Namirnice() {
		return id_Namirnice;
	}

	public void setId_Namirnice(long id_namirnice) {
		this.id_Namirnice = id_namirnice;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
