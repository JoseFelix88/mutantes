package com.meli.mutante.service.impl.processor;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author USUARIO
 *
 */
public class MutanteProcessorTest {

	private static final Logger log = LoggerFactory.getLogger(MutanteProcessorTest.class);
	
	/**
	 * @throws Exception
	 */
	@Test
	public void testDnaProcessorStructure() throws Exception {
		List<String> adns = Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");
		log.debug("Procesar la estructura de la secuencia de adns.");
		int sizeSecuencia = adns.size();
		char[][] dna = new char[sizeSecuencia][sizeSecuencia];

		int index = 0;

		for (String secuencia : adns) {
			dna[index] = secuencia.toUpperCase().toCharArray();
			index++;
		}

	}

	@Test
	public void testCheckConsistencia() throws Exception {
		List<String> listDna = Arrays.asList("ATGCGA", "ATGCGA", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");
		Pattern baseNitrogenada = Pattern.compile("[atcg]+", Pattern.CASE_INSENSITIVE);

		for (String dna : listDna) {
			if (dna.length() != 6) {
				throw new Exception("La secuencia de ADN: " + dna + " no cumple con el tamaño permitido.");
			}

			if (!baseNitrogenada.matcher(dna).matches()) {
				throw new Exception("La secuencia de ADN: " + dna + " no cumple con la estructura de base nitrogenada (atcg) permitida.");
			}
		}
	}

}
