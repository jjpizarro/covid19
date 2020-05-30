package edu.unimagdalena.covid.services;

import java.util.List;

import edu.unimagdalena.covid.entities.Caso;
import edu.unimagdalena.covid.entities.Persona;

public interface CasoService {
	Caso saveOrUpdate(Caso caso);
	Persona crearPersona(Persona persona);
	Caso findById(Long id);
	void delete(Caso caso);
	List<Persona> listaPersonas();
	
}
