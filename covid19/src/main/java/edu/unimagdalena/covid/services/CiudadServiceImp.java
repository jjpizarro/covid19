package edu.unimagdalena.covid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unimagdalena.covid.entities.Caso;
import edu.unimagdalena.covid.entities.Ciudad;
import edu.unimagdalena.covid.entities.Departamento;
import edu.unimagdalena.covid.repositories.CiudadRepository;
@Service
public class CiudadServiceImp implements CiudadService {
	
	@Autowired 
	CiudadRepository ciudadRepository;
	
	@Override
	public List<Ciudad> findCiudadesByDepartamento(Departamento departamento) {
		return ciudadRepository.findCiudadesByDepartamento(departamento.getId());
	}

	@Override
	public List<Caso> findCasosByCiudad(Ciudad ciudad) {
		return ciudadRepository.findCasoByCiudadId(ciudad.getId());
	}

	@Override
	public Ciudad finById(Long id) {
		return ciudadRepository.getOne(id);
	}

	@Override
	public Ciudad buscarCiudadPorID(Long id) {
		// TODO Auto-generated method stub
		return ciudadRepository.buscarPorID(id);
	}

}
