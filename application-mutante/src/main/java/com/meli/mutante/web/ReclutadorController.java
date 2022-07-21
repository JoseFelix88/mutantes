package com.meli.mutante.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meli.mutante.dto.DnaSequenceDto;
import com.meli.mutante.service.api.reclutador.ReclutadorService;

@RestController
public class ReclutadorController {

	@Autowired 
	private ReclutadorService rService;
	
	
	@PostMapping(value = "/mutant")
	public ResponseEntity<?> isMutant(@RequestBody DnaSequenceDto dnaDto) throws Exception {
		boolean isMutant = rService.isMutant(dnaDto);
		if (isMutant) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

	}

}
