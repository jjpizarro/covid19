package edu.unimagdalena.covid.services;

import java.util.List;

import edu.unimagdalena.covid.entities.Departamento;

public interface DepartamentoService {
	List<Departamento> findAll();
	Departamento findById(Long id);
	
	
}
