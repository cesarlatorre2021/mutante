package com.adn.mutante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.mutante.entity.Dna;
import com.adn.mutante.entity.ValidacionesADN;
import com.adn.mutante.repository.MutanteRepository;

@Service
public class MutanteService {
	
	@Autowired
	private MutanteRepository mutanteRepository;
	
	public static boolean isMutant(String[] dnaAux) {
		
		boolean snMutante = false;
		int posLetraCadenaAux;
		int posCadenaAux;
		String cadena;
		int cont = 0;
		
		ValidacionADN  validar = new ValidacionADN();

		for(int posCadena = 0; posCadena<dnaAux.length; posCadena++){  // Ciclo que permite recorrer todo el arreglo

			dnaAux[posCadena] = dnaAux[posCadena] + "*";
			cadena = dnaAux[posCadena];
					
			for (int posLetraCadena = 0; posLetraCadena<(cadena.length()-1); posLetraCadena++) { 	//Ciclo que permite recorre toda la cadena de caracteres
				
				boolean posibleMutante = false;
				char letra = cadena.charAt(posLetraCadena);
				
				if (letra == cadena.charAt(posLetraCadena + 1)) {
					posibleMutante = validar.validarCadenaADNMutante(posCadena, posLetraCadena, posCadena, (posLetraCadena + 1), letra, cadena, dnaAux);	
					 
				    if (posibleMutante) {
					  cont++;
				    }
				    
				} 
				
				if (posibleMutante==false) {				
					if (posCadena != cadena.length()) {			
						
						posLetraCadenaAux = posLetraCadena;
						posCadenaAux      = posCadena;				
						
						posCadenaAux++; //Aumenta para tomar la siguiente fila
						posLetraCadenaAux--; //Disminuye para tomar la letra anterior
						
						for (int i = 0; i<=2; i++) {						
							if(posLetraCadenaAux != -1 && posLetraCadenaAux < (cadena.length()-1) && posCadenaAux < dnaAux.length ) {						
								if (letra == dnaAux[posCadenaAux].charAt(posLetraCadenaAux)) {
									posibleMutante = validar.validarCadenaADNMutante(posCadena, posLetraCadena, posCadenaAux, posLetraCadenaAux, letra, cadena, dnaAux);
									
									if (posibleMutante) {
									  cont++;
								    }
									
								} 							
							}								
							posLetraCadenaAux++;			
						}
						
				    }
				}	
	
			}
		}
		
		if (cont > 0) {
			snMutante = true;
		}
		
		return snMutante;						
	}
	
	public List<Dna> getAll() {		
        return mutanteRepository.getAll();
    }
	
	public Dna save(Dna dna) {
        return mutanteRepository.save(dna);
    }

    public ValidacionesADN validacion() {	
    	
    	List<Dna> mutante = mutanteRepository.getAll();
    	
		int contMutantes   = 0;
		int contNOMutantes = 0;
		ValidacionesADN validacionesADN = new ValidacionesADN();
		
		for (Dna dna : mutante) {
             
        	String[] Auxdna = new String[dna.getDna().length];
            System.arraycopy(dna.getDna(), 0, Auxdna, 0, dna.getDna().length);

    		if (isMutant(Auxdna)) {
    			contMutantes++;
    		}else {
    			contNOMutantes++;
    		}		  
    
    	}  
		
		validacionesADN.setCount_mutant_dna(contMutantes);
		validacionesADN.setCount_human_dna(contNOMutantes);

		return validacionesADN;
    }
    
}
