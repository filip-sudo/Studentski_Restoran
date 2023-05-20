package com.example.demo.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Meni;
import com.example.demo.repository.MeniRepository;
import com.example.demo.services.MeniService;

@Service
@Transactional
public class MeniServiceImpl implements MeniService{
	
	@Autowired
	private MeniRepository MeniRepository;
	
	
	
	
	
	@Override
	public Meni createMeni(Meni Meni) {
		return MeniRepository.save(Meni);
	}
	
	
	
	
	
	
	
	@Override
	public Meni updateMeni(Meni dataMeni) throws ResourceNotFoundException{
		Optional<Meni>productDb = this.MeniRepository.findById(dataMeni.getId_meni());
		
		if (productDb.isPresent()) {
			Meni MeniUpdate = productDb.get();
			MeniUpdate.setNaziv(dataMeni.getNaziv());
			MeniUpdate.setJuha(dataMeni.getJuha());
			MeniUpdate.setGlavno_jelo(dataMeni.getGlavno_jelo());
			MeniUpdate.setDesert(dataMeni.getDesert());
			MeniUpdate.setVege(dataMeni.getVege());
			/*
			MeniUpdate.setNamirnice(dataMeni.getNamirnice());
			*/
			MeniUpdate.setKalorije(dataMeni.getKalorije());
			MeniUpdate.setCijena(dataMeni.getCijena());
			MeniRepository.save(MeniUpdate);
			return MeniUpdate;
			} else {
			throw new ResourceNotFoundException("Zapis nije pronađen : " +
			dataMeni.getId_meni());
			}

	}
	
	
	
	
	
	
	
	@Override
	public Iterable<Meni> getAllMeni() {
	return this.MeniRepository.findAll();
	}
	
	
	
	
	
	
	@Override
	public Meni getMeni(long MeniId) {
		if (MeniId == 0)
		return new Meni();
		Optional<Meni> productDb = this.MeniRepository.findById(MeniId);
		if (productDb.isPresent()) {
		return productDb.get();
		} else {
		return new Meni();
		}
		}
	
	
	
	
	@Override
	public void deleteMeni(long MeniId) {
		Optional<Meni> productDb = this.MeniRepository.findById(MeniId);
		if (productDb.isPresent()) {
		this.MeniRepository.delete(productDb.get());
		} else {
		throw new ResourceNotFoundException("Zapis nije pronađen.");
		}
		}
	
	@Override
	public List<Meni> getByKeyword(String keyword){
		return MeniRepository.findByKeyword(keyword);
	}


}
