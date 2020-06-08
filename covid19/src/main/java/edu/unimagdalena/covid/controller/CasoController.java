package edu.unimagdalena.covid.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.unimagdalena.covid.entities.Caso;
import edu.unimagdalena.covid.entities.Persona;
import edu.unimagdalena.covid.services.CasoService;

@RestController
public class CasoController {
	@Autowired
	private CasoService casoService;
	
	@PostMapping("/crear-caso")
	@PreAuthorize("ROLE_ADMIN")
	public ResponseEntity<Caso> crearCaso(@Valid @RequestBody Caso caso) {
		Persona nuevoPaciente = casoService.crearPersona(caso.getPersona());
		caso.setPersona(nuevoPaciente);
		Caso nuevoCaso = casoService.saveOrUpdate(caso);
		return new ResponseEntity<Caso>(nuevoCaso,HttpStatus.CREATED);
	}
	
	@PostMapping("/crear-persona")
	public ResponseEntity<Persona> crearPersona(@Valid @RequestBody Persona persona) {
		
		Persona nuevoPersona = casoService.crearPersona(persona);
		
		return new ResponseEntity<Persona>(nuevoPersona,HttpStatus.CREATED);
	}
	@GetMapping("/personas")
	public ResponseEntity<List<Persona>> listaPersonas(){
		List<Persona> personas = casoService.listaPersonas();
		return new ResponseEntity<List<Persona>>(personas,HttpStatus.OK);
	}
}
