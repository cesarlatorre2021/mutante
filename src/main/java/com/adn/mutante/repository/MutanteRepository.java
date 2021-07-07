package com.adn.mutante.repository;

import java.util.List;

import com.adn.mutante.entity.Dna;

public interface MutanteRepository {
	
	List<Dna> getAll();
	Dna save(Dna dna);

}
