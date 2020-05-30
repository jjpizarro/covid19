package edu.unimagdalena.covid.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.covid.entities.Caso;
import edu.unimagdalena.covid.entities.Ciudad;
@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
	@Query("SELECT c FROM Ciudad c where c.departamento.id = :id") 
	List<Ciudad> findCiudadesByDepartamento(@Param("id") Long departamentoId);
	
	@Query("select c from Ciudad c where c.id = :i")
	Ciudad buscarPorID(@Param("i") Long id);
	
	
	
	@Query("SELECT cs FROM Caso cs INNER JOIN Ciudad c ON cs.ciudad.id = c.id where c.id = :id") 
	List<Caso> findCasoByCiudadId(@Param("id") Long id);
}
