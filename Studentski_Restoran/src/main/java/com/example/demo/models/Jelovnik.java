package com.example.demo.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "Jelovnik")
public class Jelovnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_jelovnik;
	
	@Column
	private String restoran;
	
	@Column
	private String adresa;
	/*
	@Column
	ArrayList<Meni> meni;
	*/
	@Column
	private LocalDateTime datum;

	public long getId_jelovnik() {
		return id_jelovnik;
	}

	public void setId_jelovnik(long id_jelovnik) {
		this.id_jelovnik = id_jelovnik;
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
/*(
	public ArrayList<Meni> getMeni() {
		return meni;
	}

	public void setMeni(ArrayList<Meni> meni) {
		this.meni = meni;
	}
*/
	public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}
	
	
	
	
	
	
}
