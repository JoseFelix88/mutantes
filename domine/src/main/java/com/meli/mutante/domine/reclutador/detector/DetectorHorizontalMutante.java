package com.meli.mutante.domine.reclutador.detector;

import java.util.List;

import com.meli.mutante.domine.reclutador.DetectorProcessor;
import com.meli.mutante.dto.DnaSequenceDto;
import com.meli.mutante.dto.enums.SearchDireccion;

public class DetectorHorizontalMutante implements DetectorProcessor {

	@Override
	public Integer detector(DnaSequenceDto dna, SearchDireccion direccion) {
		Integer secuence = 0;
			secuence = processorSearchHorizontal(dna.getDna());
		return secuence;
	}

	private Integer processorSearchHorizontal(List<String> dna) {
		Integer secuencia = 0;
		for (int i = 0; i < dna.size(); i++) {
			String literal = dna.get(i);
			if(literal.equals("A")) {
				secuencia++;
			}
		}
		
		return secuencia;
	}


}
