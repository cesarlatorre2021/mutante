package com.adn.mutante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adn.mutante.entity.Dna;
import com.adn.mutante.entity.ValidacionesADN;
import com.adn.mutante.service.MutanteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
//@RequestMapping("/mutant")
public class MutanteController {
	
	@Autowired
    private MutanteService mutanteService;
	
    @GetMapping("/stats")
    @ApiOperation("Permite validar las estadisticas de las verificaciones de ADN")
    @ApiResponse(code = 200, message = "OK")
   	public ResponseEntity<ValidacionesADN> isMutant() {	
        return new ResponseEntity<ValidacionesADN> (mutanteService.validacion(),HttpStatus.OK);
   	}
    
    @PostMapping("/mutant")
    @ApiOperation("Permite validar la secuencia ADN para saber si es mutante o humano")
    @ApiResponse(code = 200, message = "OK")
   	public ResponseEntity<List<Dna>> save(@RequestBody List<Dna> mutante) {
    	boolean isMutant = false;
    	
		for (Dna dna : mutante) {           
        	String[] Auxdna = new String[dna.getDna().length];
            System.arraycopy(dna.getDna(), 0, Auxdna, 0, dna.getDna().length);
            isMutant = MutanteService.isMutant(Auxdna);	  
            mutanteService.save(dna);
    	} 
		
		if(isMutant) {
			return new ResponseEntity<List<Dna>> (mutante,HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Dna>> (mutante,HttpStatus.FORBIDDEN);
		}
    		
   	}
    
}
