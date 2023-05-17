package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Jelovnik;

public interface JelovnikRepository extends JpaRepository<Jelovnik, Long> {

}
