package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Meni;

public interface MeniRepository extends JpaRepository<Meni, Long> {
	
	//Custom query
	 @Query(value = "select * from meni where naziv like %:keyword% or id_meni like %:keyword% or juha like %:keyword% "
	 		+ "or glavno_jelo like %:keyword% or desert like %:keyword% or id_meni like %:keyword% "
	 		+ "or vege like %:keyword% or kalorije like %:keyword% or cijena like %:keyword%", nativeQuery = true)
	 List<Meni> findByKeyword(@Param("keyword") String keyword);

}
