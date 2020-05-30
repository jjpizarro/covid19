package edu.unimagdalena.covid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.covid.entities.Departamento;
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Long>{

}
