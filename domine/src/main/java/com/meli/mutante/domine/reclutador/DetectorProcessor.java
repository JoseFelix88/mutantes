package com.meli.mutante.domine.reclutador;

import com.meli.mutante.dto.DnaSequenceDto;
import com.meli.mutante.dto.enums.SearchDireccion;

public interface DetectorProcessor {

	public Integer detector(DnaSequenceDto dna, SearchDireccion direccion);
	
	
}
