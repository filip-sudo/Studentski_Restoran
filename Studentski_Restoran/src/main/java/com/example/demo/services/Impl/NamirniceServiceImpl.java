package com.example.demo.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Meni;
import com.example.demo.models.Namirnice;
import com.example.demo.repository.NamirniceRepository;
import com.example.demo.services.NamirniceService;

@Service
@Transactional
public class NamirniceServiceImpl implements NamirniceService{
	
	@Autowired
	private NamirniceRepository NamirniceRepository;
	
	
	
	
	
	@Override
	public Namirnice createNamirnice(Namirnice Namirnice) {
		return NamirniceRepository.save(Namirnice);
	}
	
	
	
	
	
	
	
	@Override
	public Namirnice updateNamirnice(Namirnice dataNamirnice) throws ResourceNotFoundException{
		Optional<Namirnice>productDb = this.NamirniceRepository.findById(dataNamirnice.getId_Namirnice());
		
		if (productDb.isPresent()) {
			Namirnice NamirniceUpdate = productDb.get();
			NamirniceUpdate.setNaziv(dataNamirnice.getNaziv());
			NamirniceRepository.save(NamirniceUpdate);
			return NamirniceUpdate;
			} else {
			throw new ResourceNotFoundException("Zapis nije pronađen : " +
			dataNamirnice.getId_Namirnice());
			}

	}
	
	
	
	
	
	
	
	@Override
	public Iterable<Namirnice> getAllNamirnice() {
	return this.NamirniceRepository.findAll();
	}
	
	
	
	
	
	
	@Override
	public Namirnice getNamirnice(long NamirniceId) {
		if (NamirniceId == 0)
		return new Namirnice();
		Optional<Namirnice> productDb = this.NamirniceRepository.findById(NamirniceId);
		if (productDb.isPresent()) {
		return productDb.get();
		} else {
		return new Namirnice();
		}
		}
	
	
	
	
	@Override
	public void deleteNamirnice(long NamirniceId) {
		Optional<Namirnice> productDb = this.NamirniceRepository.findById(NamirniceId);
		if (productDb.isPresent()) {
		this.NamirniceRepository.delete(productDb.get());
		} else {
		throw new ResourceNotFoundException("Zapis nije pronađen.");
		}
		}
	
	@Override
	public List<Namirnice> getByKeyword(String keyword){
		return NamirniceRepository.findByKeyword(keyword);
	}


}
