package com.adn.mutante.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adn.mutante.entity.Dna;
import com.adn.mutante.persistence.crud.MutanteCrudRepository;
import com.adn.mutante.repository.MutanteRepository;

@Repository
public class MutanteRepositoryImpl implements MutanteRepository {
	
	@Autowired
	private MutanteCrudRepository mutanteCrudRepository;

	@Override
	public List<Dna> getAll() {
		return (List<Dna>) mutanteCrudRepository.listarAdnMutanteID();	
	}

	@Override
	public Dna save(Dna mutante) {
		return mutanteCrudRepository.save(mutante);
	}

}
