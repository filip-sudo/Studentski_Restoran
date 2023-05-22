package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Namirnice;

public interface NamirniceRepository extends JpaRepository<Namirnice, Long> {
	
	//Custom query
		 @Query(value = "select * from namirnice where naziv like %:keyword% or id_namirnice like %:keyword%", nativeQuery = true)
		 List<Namirnice> findByKeyword(@Param("keyword") String keyword);
	
}
