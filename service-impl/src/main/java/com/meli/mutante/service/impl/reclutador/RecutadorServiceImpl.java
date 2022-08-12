package com.meli.mutante.service.impl.reclutador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.mutante.dto.DnaSequenceDto;
import com.meli.mutante.service.api.reclutador.ReclutadorService;
import com.meli.mutante.service.impl.processor.MutanteProcessor;

@Service
public class RecutadorServiceImpl implements ReclutadorService {

	@Autowired
	private MutanteProcessor mProcessor;

	@Override
	public boolean isMutant(DnaSequenceDto dna) throws Exception {
		return mProcessor.dnaProcessor(dna);
	}

}
