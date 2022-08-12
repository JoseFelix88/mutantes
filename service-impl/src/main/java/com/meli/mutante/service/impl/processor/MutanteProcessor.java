package com.meli.mutante.service.impl.processor;

import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.meli.mutante.dto.DnaSequenceDto;

@Component
public class MutanteProcessor {
	
	private static final Logger log = LoggerFactory.getLogger(MutanteProcessor.class);
	
	@Value("${found.secuence}")
	private Integer foundSecuence;
	
	@Value("${count.secuence.find}")
	private Integer countSecuenceFind;
	
	
	public boolean dnaProcessor(DnaSequenceDto dna) throws Exception {
		log.debug("Procesar la estructura de la secuencia de dna enviada.");
		List<String> listDna = dna.getDna();
		checkConsistencia(listDna);
		char[][] dnaSecuencia = dnaProcessorStructure(listDna);
		BuscadorProcessor buscador = new BuscadorProcessor(dnaSecuencia, foundSecuence, countSecuenceFind);
		return buscador.existMutante();
	}
	
	char[][] dnaProcessorStructure(List<String> adns) {
		log.debug("Procesar la estructura de la secuencia de adns.");
		int sizeSecuencia = adns.size();
		char[][] dna = new char[sizeSecuencia][sizeSecuencia];

		int index = 0;

		for (String secuencia : adns) {
			dna[index] = secuencia.toUpperCase().toCharArray();
			index++;
		}

		return dna;
	}
	
	void checkConsistencia(List<String> dnas) throws Exception {

		Pattern baseNitrogenada = Pattern.compile("[atcg]+", Pattern.CASE_INSENSITIVE);

		for (String dna : dnas) {
			if (dna.length() != 6) {
				throw new Exception("La secuencia de ADN: " + dna + " no cumple con el tamaño permitido.");
			}

			if (!baseNitrogenada.matcher(dna).matches()) {
				throw new Exception("La secuencia de ADN: " + dna
						+ " no cumple con la estructura de base nitrogenada (atcg) permitida.");
			}
		}

	}
	
	
}
