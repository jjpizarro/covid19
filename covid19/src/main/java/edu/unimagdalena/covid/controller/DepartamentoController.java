package edu.unimagdalena.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unimagdalena.covid.entities.Departamento;
import edu.unimagdalena.covid.services.DepartamentoService;

@RestController
public class DepartamentoController {
	@Autowired
	DepartamentoService dptoService;
	
	@GetMapping("/departamentos")
	public ResponseEntity<List<Departamento>> getDepartamentos(){
		
		List<Departamento> departamentos = dptoService.findAll();
		
		if(departamentos != null)
			return new ResponseEntity<List<Departamento>>(departamentos, HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
