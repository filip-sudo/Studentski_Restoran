package com.example.demo.models;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Meni")
public class Meni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_meni;
	
	@Column
	@NotEmpty(message = "Naziv ne smije biti prazno!")
	private String naziv;
	
	@Column
	@NotEmpty(message = "Juha ne smije biti prazno!")
	private String juha;
	
	@Column
	@NotEmpty(message = "Glavno jelo ne smije biti prazno!")
	private String glavno_jelo;
	
	@Column
	@NotEmpty(message = "Desert ne smije biti prazno!")
	private String desert;
	
	@Column
	private Boolean vege;
	
	@Column
	@Min(value = 1, message = "Kalorije moraju biti vece od 1!")
	private double kalorije;
	
	@Column
	@Min(value = 1, message = "Cijena mora biti veca od 1!")
	private double cijena;
	
	/*
	@ManyToMany(mappedBy = "spojiMeni")
	Set<Jelovnik> spojJelovnik;
	*/
	
	
	

	public long getId_meni() {
		return id_meni;
	}

	public void setId_meni(long id_meni) {
		this.id_meni = id_meni;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getJuha() {
		return juha;
	}

	public void setJuha(String juha) {
		this.juha = juha;
	}

	public String getGlavno_jelo() {
		return glavno_jelo;
	}

	public void setGlavno_jelo(String glavno_jelo) {
		this.glavno_jelo = glavno_jelo;
	}

	public String getDesert() {
		return desert;
	}

	public void setDesert(String desert) {
		this.desert = desert;
	}

	public Boolean getVege() {
		return vege;
	}

	public void setVege(Boolean vege) {
		this.vege = vege;
	}

	public double getKalorije() {
		return kalorije;
	}

	public void setKalorije(double kalorije) {
		this.kalorije = kalorije;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	
	

}
