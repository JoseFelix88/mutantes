package com.meli.mutante.service.impl.reclutador;

import org.springframework.stereotype.Service;

import com.meli.mutante.dto.DnaSequenceDto;
import com.meli.mutante.service.api.reclutador.ReclutadorService;

@Service
public class RecutadorServiceImpl implements ReclutadorService {

	@Override
	public boolean isMutant(DnaSequenceDto dna) {
		
		return false;
	}

}
