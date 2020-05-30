package edu.unimagdalena.covid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unimagdalena.covid.entities.Departamento;
import edu.unimagdalena.covid.repositories.DepartamentoRepository;
@Service
public class DepartamentoServiceImp implements DepartamentoService {
	@Autowired
	DepartamentoRepository dRepository;
	@Override
	public List<Departamento> findAll() {
		return dRepository.findAll();
	}

	@Override
	public Departamento findById(Long id) {
		return dRepository.getOne(id);
	}

}
