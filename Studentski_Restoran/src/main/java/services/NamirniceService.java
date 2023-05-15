package services;

import models.Namirnice;

public class NamirniceService {
	
	public Namirnice createNamirnice(Namirnice Namirnice);
	
	Namirnice updateNamirnice(Namirnice Namirnice);
	
	public Iterable<Namirnice>getAllNamirnice();
	
	Namirnice getNamirnice(long id_Namirnice);
	
	void deleteNamirnice(long id);
	
}
