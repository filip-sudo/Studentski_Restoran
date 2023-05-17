package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Meni")
public class Meni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_meni;
	
	@Column
	private String naziv;
	
	@Column
	private String juha;
	
	@Column
	private String glavno_jelo;
	
	@Column
	private String desert;
	
	@Column
	private Boolean vege;
	/*
	@Column
	List<Namirnice> namirnice;
	*/
	@Column
	private double kalorije;
	
	@Column
	private double cijena;
	
	
	
	

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
	/*
	public List<Namirnice> getNamirnice(){
		return namirnice;
	}
	
	public void setNamirnice(List<Namirnice> namirnice){
		this.namirnice = namirnice;
	}
*/
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
