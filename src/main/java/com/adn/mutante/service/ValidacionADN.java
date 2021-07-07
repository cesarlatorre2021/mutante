package com.adn.mutante.service;

public class ValidacionADN {
	
	public boolean validarCadenaADNMutante(int posCadena, int posLetraCadena, int posCadenaAux, int posLetraCadenaAux, char letra, String cadena, String[] dnaAux){
		
		boolean snMutante   = false;
		
		if(posCadena < posCadenaAux && posLetraCadena < posLetraCadenaAux && posCadenaAux <= dnaAux.length) {
			
			snMutante = oblicuaDerecha(posCadenaAux, posLetraCadenaAux, letra, cadena, dnaAux);
			
		}else if(posCadena < posCadenaAux && posLetraCadena > posLetraCadenaAux && posCadenaAux <= dnaAux.length) {
			
			snMutante = oblicuaIzquierda(posCadenaAux, posLetraCadenaAux, letra, cadena, dnaAux);
			
		}else if(posCadena < posCadenaAux && posLetraCadena == posLetraCadenaAux && posCadenaAux <= dnaAux.length) {
			
			snMutante = horizontal(posCadenaAux, posLetraCadenaAux, letra, cadena, dnaAux);
			
		}else if(posCadena == posCadenaAux && posLetraCadena < posLetraCadenaAux && posCadenaAux <= dnaAux.length) {
			
			snMutante = vertical(posCadenaAux, posLetraCadenaAux, letra, cadena, dnaAux);
		}
		
		return snMutante;
	}

	public boolean horizontal(int posCadenaAux, int posLetraCadenaAux, char letra, String cadena, String[] dnaAux) {
		
		int cont = 0;
		int cont2 = 0;
		boolean snMutante   = false;
		
		while (cont <=1 && snMutante != true) {

			posCadenaAux++; //Aumenta para tomar la siguiente fila	
			
			if ((posLetraCadenaAux > -1 && posLetraCadenaAux <= (cadena.length()-2))  && posCadenaAux <= dnaAux.length - 1 ) {
				char A = dnaAux[posCadenaAux].charAt(posLetraCadenaAux);
				
				if (letra == A) {
					cont2++;
					if (cont2 == 2) {
					  snMutante = true;
					}					
				}
			}	
			cont++;
		}
		return snMutante;
	}
	
	public boolean vertical(int posCadenaAux, int posLetraCadenaAux, char letra, String cadena, String[] dnaAux) {
		
		int cont = 0;
		int cont2 = 0;
		boolean snMutante   = false;
		
		while (cont <=1 && snMutante != true) {

			posLetraCadenaAux++; //Aumenta para tomar la siguiente fila
													
			if ((posLetraCadenaAux > -1 && posLetraCadenaAux <= (cadena.length()-2))  && posCadenaAux <= dnaAux.length - 1 ) {
				char A = dnaAux[posCadenaAux].charAt(posLetraCadenaAux);
				
				if (letra == A) {
					cont2++;
					if (cont2 == 2) {
					  snMutante = true;
					}					
				}
			}
			cont++;
		}
		
		return snMutante;
	}
	
	public boolean oblicuaDerecha(int posCadenaAux, int posLetraCadenaAux, char letra, String cadena, String[] dnaAux) {
		
		int cont = 0;
		int cont2 = 0;
		boolean snMutante = false;
		
		while (cont <=1 && snMutante != true) {
			
			posCadenaAux++; //Aumenta para tomar la siguiente fila
			posLetraCadenaAux++; //Aumenta para tomar la siguiente letra segun logica de negocio
			
			if ((posLetraCadenaAux > -1 && posLetraCadenaAux <= (cadena.length()-2)) && posCadenaAux <= dnaAux.length - 1 ) {

				char A = dnaAux[posCadenaAux].charAt(posLetraCadenaAux);
				
				if (letra == A ) {	
					cont2++;
					if (cont2 == 2) {
					  snMutante = true;
					}						
				}
			}
			cont ++;
		}
		
		return snMutante;
	}
	
	public boolean oblicuaIzquierda(int posCadenaAux, int posLetraCadenaAux, char letra, String cadena, String[] dnaAux) {
		
		int cont = 0;
		int cont2 = 0;
		boolean snMutante   = false;
		
		while (cont <=1 && snMutante != true) {
			
			posCadenaAux++; //Aumenta para tomar la siguiente fila
			posLetraCadenaAux--; //Aumenta para tomar la siguiente letra segun logica de negocio
			
			if ((posLetraCadenaAux > -1 && posLetraCadenaAux <= (cadena.length()-2)) && posCadenaAux <= dnaAux.length - 1 ) {

				char A = dnaAux[posCadenaAux].charAt(posLetraCadenaAux);
				
				if (letra == A ) {	
					cont2++;
					if (cont2 == 2) {
					  snMutante = true;
					}						
				}
			}
			cont ++;
		}
		
		return snMutante;
	}

}
