package edu.unimagdalena.covid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.covid.entities.Persona;
@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long>{

}
