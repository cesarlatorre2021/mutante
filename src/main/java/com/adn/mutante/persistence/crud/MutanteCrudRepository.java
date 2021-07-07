package com.adn.mutante.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adn.mutante.entity.Dna;


public interface MutanteCrudRepository extends CrudRepository <Dna, Integer>{
	
	@Query(value = "SELECT * "
			+ "       FROM MUTANTE", nativeQuery = true)
	List<Dna> listarAdnMutanteID();

}
