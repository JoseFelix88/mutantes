package com.meli.mutante.dto;

import java.io.Serializable;
import java.util.List;

public class DnaSequenceDto implements Serializable {

	private static final long serialVersionUID = -2170242163440715171L;
	
	
	private List<String> dna;
	

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}

}
