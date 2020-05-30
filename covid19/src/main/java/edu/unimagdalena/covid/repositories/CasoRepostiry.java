package edu.unimagdalena.covid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.covid.entities.Caso;
@Repository
public interface CasoRepostiry extends JpaRepository<Caso, Long> {

}
