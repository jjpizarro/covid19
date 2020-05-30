package edu.unimagdalena.covid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unimagdalena.covid.entities.Caso;
import edu.unimagdalena.covid.entities.Persona;
import edu.unimagdalena.covid.repositories.CasoRepostiry;
import edu.unimagdalena.covid.repositories.PersonaRepository;
@Service
public class CasoServiceImp implements CasoService {
	@Autowired
	private CasoRepostiry cRepository;
	@Autowired
	private PersonaRepository pRepository;
	@Override
	public Caso saveOrUpdate(Caso caso) {
		
		return cRepository.save(caso);

	}

	@Override
	public Caso findById(Long id) {
		return cRepository.getOne(id);
	}

	@Override
	public void delete(Caso caso) {
		cRepository.delete(caso);

	}

	@Override
	public Persona crearPersona(Persona persona) {
		
		return pRepository.save(persona);
		
	}

	@Override
	public List<Persona> listaPersonas() {
		
		return pRepository.findAll();
	}

}
