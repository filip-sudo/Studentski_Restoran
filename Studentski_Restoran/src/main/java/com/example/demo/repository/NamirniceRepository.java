package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Namirnice;

public interface NamirniceRepository extends JpaRepository<Namirnice, Long> {
	
}
