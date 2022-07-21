package com.meli.mutante.service.api.reclutador;

import com.meli.mutante.dto.DnaSequenceDto;

public interface ReclutadorService {

	public boolean isMutant(DnaSequenceDto dnaDto) throws Exception;
	
}
