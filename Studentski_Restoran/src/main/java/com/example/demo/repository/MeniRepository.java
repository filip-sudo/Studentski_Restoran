package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Meni;

public interface MeniRepository extends JpaRepository<Meni, Long> {

}
