package com.meli.mutante.dto;

public class ReclutadorDto {

	private char[][] dna;
	
	private Integer countSecuenceFind;
	
	private Integer foundSecuence;
	
	private Integer found;

	public char[][] getDna() {
		return dna;
	}

	public void setDna(char[][] dna) {
		this.dna = dna;
	}

	public Integer getCountSecuenceFind() {
		return countSecuenceFind;
	}

	public void setCountSecuenceFind(Integer countSecuenceFind) {
		this.countSecuenceFind = countSecuenceFind;
	}

	public Integer getFoundSecuence() {
		return foundSecuence;
	}

	public void setFoundSecuence(Integer foundSecuence) {
		this.foundSecuence = foundSecuence;
	}

	public Integer getFound() {
		return found;
	}

	public void setFound(Integer found) {
		this.found = found;
	}

	
}
