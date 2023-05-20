package com.example.demo.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Jelovnik;
import com.example.demo.repository.JelovnikRepository;
import com.example.demo.services.JelovnikService;

@Service
@Transactional
public class JelovnikServiceImpl implements JelovnikService{
	
	@Autowired
	private JelovnikRepository JelovnikRepository;
	
	
	
	
	
	@Override
	public Jelovnik createJelovnik(Jelovnik Jelovnik) {
		return JelovnikRepository.save(Jelovnik);
	}
	
	
	
	
	
	
	
	@Override
	public Jelovnik updateJelovnik(Jelovnik dataJelovnik) throws ResourceNotFoundException{
		Optional<Jelovnik>productDb = this.JelovnikRepository.findById(dataJelovnik.getId_jelovnik());
		
		if (productDb.isPresent()) {
			Jelovnik JelovnikUpdate = productDb.get();
			JelovnikUpdate.setNaziv(dataJelovnik.getNaziv());
			JelovnikUpdate.setRestoran(dataJelovnik.getRestoran());
			JelovnikUpdate.setAdresa(dataJelovnik.getAdresa());
			JelovnikUpdate.setDatum(dataJelovnik.getDatum());
			JelovnikRepository.save(JelovnikUpdate);
			return JelovnikUpdate;
			} else {
			throw new ResourceNotFoundException("Zapis nije pronađen : " +
			dataJelovnik.getId_jelovnik());
			}

	}
	
	
	
	
	
	
	
	@Override
	public Iterable<Jelovnik> getAllJelovnik() {
	return this.JelovnikRepository.findAll();
	}
	
	
	
	
	
	
	@Override
	public Jelovnik getJelovnik(long JelovnikId) {
		if (JelovnikId == 0)
		return new Jelovnik();
		Optional<Jelovnik> productDb = this.JelovnikRepository.findById(JelovnikId);
		if (productDb.isPresent()) {
		return productDb.get();
		} else {
		return new Jelovnik();
		}
		}
	
	
	
	
	@Override
	public void deleteJelovnik(long JelovnikId) {
		Optional<Jelovnik> productDb = this.JelovnikRepository.findById(JelovnikId);
		if (productDb.isPresent()) {
		this.JelovnikRepository.delete(productDb.get());
		} else {
		throw new ResourceNotFoundException("Zapis nije pronađen.");
		}
		}
	
	@Override
	public List<Jelovnik> getByKeyword(String keyword){
		return JelovnikRepository.findByKeyword(keyword);
	}


}