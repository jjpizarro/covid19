package edu.unimagdalena.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.unimagdalena.covid.entities.Caso;
import edu.unimagdalena.covid.entities.Ciudad;
import edu.unimagdalena.covid.entities.Departamento;
import edu.unimagdalena.covid.services.CiudadService;
import edu.unimagdalena.covid.services.DepartamentoService;

@RestController
public class CiudadController {
	@Autowired
	private CiudadService ciudadService;
	@Autowired
	private DepartamentoService deptoService;
	
	@GetMapping("/ciudades/{departamentos}")
	public ResponseEntity<List<Ciudad>> getCiudadesPorDepartamento(@PathVariable("departamentos") Long deptoId){
		Departamento departamento = deptoService.findById(deptoId);
		
		List<Ciudad> ciudades = ciudadService.findCiudadesByDepartamento(departamento);
		if(ciudades != null)
			return new ResponseEntity<List<Ciudad>>(ciudades, HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/ciudades/{ciudad}/casos")
	public ResponseEntity<List<Caso>> getCasosPorCiudad(@PathVariable("ciudad") Long ciudadId){
		Ciudad ciudad = ciudadService.finById(ciudadId);
		List<Caso> casos = ciudadService.findCasosByCiudad(ciudad);
		if(casos != null)
			return new ResponseEntity<List<Caso>>(casos, HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
	}
	
	@GetMapping("/ciudad/{idciudad}")
	public Ciudad buscarCiudad(@PathVariable("idciudad") Long id) {
		return ciudadService.buscarCiudadPorID(id);
	}
}
