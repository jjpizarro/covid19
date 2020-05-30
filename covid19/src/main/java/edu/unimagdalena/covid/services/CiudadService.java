package edu.unimagdalena.covid.services;

import java.util.List;

import edu.unimagdalena.covid.entities.Caso;
import edu.unimagdalena.covid.entities.Ciudad;
import edu.unimagdalena.covid.entities.Departamento;

public interface CiudadService {
	List<Ciudad> findCiudadesByDepartamento(Departamento departamento);
	List<Caso> findCasosByCiudad(Ciudad ciudad);
	Ciudad finById(Long id);
	Ciudad buscarCiudadPorID(Long id);
}
