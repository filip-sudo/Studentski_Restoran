package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Jelovnik;
import com.example.demo.models.Meni;

import jakarta.servlet.http.HttpServletResponse;

public interface PDFService {

	public void export(HttpServletResponse response, List<Meni> listaMeni, List<Jelovnik> listaJelovnik);
}
