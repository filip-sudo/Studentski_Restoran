package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Jelovnik;

public interface JelovnikRepository extends JpaRepository<Jelovnik, Long> {
	
	List<Jelovnik> findByDatumLessThan(LocalDateTime datum);
	
	//Custom query
	@Query(value = "select * from jelovnik where naziv like %:keyword% or id_jelovnik like %:keyword% or restoran like %:keyword% "
	 		+ "or adresa like %:keyword% or meni1 like %:keyword% or meni2 like %:keyword% or meni3 like %:keyword% ", nativeQuery = true)
	 List<Jelovnik> findByKeyword(@Param("keyword") String keyword);

	
		 @Query(value = "select * from jelovnik where naziv like %:keyword% or id_jelovnik like %:keyword% or restoran like %:keyword% "
		 		+ "or adresa like %:keyword% "
		 		+ "and DATEDIFF(day,datum,GETDATE()) between 0 and 30", nativeQuery = true)
		 List<Jelovnik> findByKeywordMjesecni(@Param("keyword") String keyword);
		 
		 @Query(value = "select * from jelovnik where naziv like %:keyword% or id_jelovnik like %:keyword% or restoran like %:keyword% "
			 		+ "or adresa like %:keyword% "
			 		+ "and DATEDIFF(day,datum,GETDATE()) between 0 and 7", nativeQuery = true)
			 List<Jelovnik> findByKeywordTjedni(@Param("keyword") String keyword);
		 
		 @Query(value = "select * from jelovnik where naziv like %:keyword% or id_jelovnik like %:keyword% or restoran like %:keyword% "
			 		+ "or adresa like %:keyword% "
			 		+ "and DATEDIFF(day,datum,GETDATE()) between 0 and 1", nativeQuery = true)
			 List<Jelovnik> findByKeywordDnevni(@Param("keyword") String keyword);

}
