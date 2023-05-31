package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "Jelovnik")
public class Jelovnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_jelovnik;
	
	@Column
	private String naziv;

	@Column
	private String restoran;
	
	@Column
	private String adresa;
	
	@Column
	private LocalDateTime datum;
	
	@Column
	private String meni1;
	
	@Column
	private String meni2;
	
	@Column
	private String meni3;
	
	/*
	@ManyToMany
	@JoinTable(
			name = "jelovnik_meni",
			joinColumns = @JoinColumn(name = "id_jelovnik"),
			inverseJoinColumns = @JoinColumn(name = "id_meni")
			)
	Set<Meni> spojiMeni; 
	
	
	
	
	public Set<Meni> getSpojiMeni() {
		return spojiMeni;
	}

	public void setSpojiMeni(Set<Meni> spojiMeni) {
		this.spojiMeni = spojiMeni;
	}
*/
	public long getId_jelovnik() {
		return id_jelovnik;
	}

	public void setId_jelovnik(long id_jelovnik) {
		this.id_jelovnik = id_jelovnik;
	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getRestoran() {
		return restoran;
	}

	public void setRestoran(String restoran) {
		this.restoran = restoran;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	public String getMeni1() {
		return meni1;
	}

	public void setMeni1(String meni1) {
		this.meni1 = meni1;
	}

	public String getMeni2() {
		return meni2;
	}

	public void setMeni2(String meni2) {
		this.meni2 = meni2;
	}

	public String getMeni3() {
		return meni3;
	}

	public void setMeni3(String meni3) {
		this.meni3 = meni3;
	}
	
	
	
	
	
	
	
}
