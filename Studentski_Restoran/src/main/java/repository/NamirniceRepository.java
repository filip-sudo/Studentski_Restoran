package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import models.Namirnice;

public interface NamirniceRepository extends JpaRepository<Namirnice, Long> {
	
}
