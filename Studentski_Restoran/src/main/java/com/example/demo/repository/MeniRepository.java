package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Meni;

public interface MeniRepository extends JpaRepository<Meni, Long> {
	
	//Custom query
	 @Query(value = "select * from meni where meni.naziv like %:keyword% or meni.id_meni like %:keyword% or meni.juha like %:keyword% "
	 		+ "or meni.glavno_jelo like %:keyword% or meni.desert like %:keyword% "
	 		+ "or meni.vege like %:keyword% or meni.kalorije like %:keyword% or meni.cijena like %:keyword%", nativeQuery = true)
	 List<Meni> findByKeyword(@Param("keyword") String keyword);

}
