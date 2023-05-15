package services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.Namirnice;
import repository.NamirniceRepository;
import services.NamirniceService;

@Service
@Transactional
public class NamirniceServiceImpl implements NamirniceService{
	
	@Autowired
	private NamirniceRepository NamirniceRepository;
	
	
	
	
	
	
	public Namirnice createNamirnice(Namirnice Namirnice) {
		return NamirniceRepository.save(Namirnice);
	}
	
	
	
	
	
	
	
	
	public Namirnice updateNamirnice(Namirnice dataNamirnice) throws InvalidConfigurationPropertyValueException{
		Optional<Namirnice>productDb = this.NamirniceRepository.findById(dataNamirnice.getId_Namirnice());
		
		if (productDb.isPresent()) {
			Namirnice NamirniceUpdate = productDb.get();
			NamirniceUpdate.setNaziv(dataNamirnice.getNaziv());
			NamirniceRepository.save(NamirniceUpdate);
			return NamirniceUpdate;
			} else {
			throw new InvalidConfigurationPropertyValueException("Zapis nije pronađen : " +
			dataNamirnice.getId_Namirnice(), productDb, null);
			}

	}
	
	
	
	
	
	
	
	
	public Iterable<Namirnice> getAllNamirnice() {
	return this.NamirniceRepository.findAll();
	}
	
	
	
	
	
	
	
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
	
	
	
	
	
	public void deleteNamirnice(long NamirniceId) {
		Optional<Namirnice> productDb = this.NamirniceRepository.findById(NamirniceId);
		if (productDb.isPresent()) {
		this.NamirniceRepository.delete(productDb.get());
		} else {
		throw new InvalidConfigurationPropertyValueException("Zapis nije pronađen.", productDb, null);
		}
		}


}
