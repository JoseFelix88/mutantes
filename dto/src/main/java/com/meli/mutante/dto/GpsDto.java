package com.meli.mutante.dto;

public class GpsDto {

	char dna[][];
	int indiceBajo;
	int fila;
	int columna;
	char ultimoLiteral;
	char actualLiteral;
	int indiceSeguro;
	int tamanio;

	public GpsDto(char[][] dna, int indiceBajo, int fila, int columna) {
		super();
		this.dna = dna;
		this.indiceSeguro = dna.length - 1;
		this.tamanio = dna.length;
		this.indiceBajo = indiceBajo;
		this.fila = fila;
		this.columna = columna;
		this.ultimoLiteral = dna[fila][columna];
	}

	public static GpsDto in(char[][] dna, int fila, int columna, int indice) {
		return new GpsDto(dna, indice, fila, columna);
	}

	public static GpsDto in(char[][] dna, int fila, int columna) {
		return new GpsDto(dna, 0, fila, columna);
	}

	public char[][] getDna() {
		return dna;
	}

	public void setDna(char[][] dna) {
		this.dna = dna;
	}

	public int getIndiceBajo() {
		return indiceBajo;
	}

	public void setIndiceBajo(int indiceBajo) {
		this.indiceBajo = indiceBajo;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public char getUltimoLiteral() {
		return ultimoLiteral;
	}

	public void setUltimoLiteral(char ultimoLiteral) {
		this.ultimoLiteral = ultimoLiteral;
	}

	public char getActualLiteral() {
		return actualLiteral;
	}

	public void setActualLiteral(char actualLiteral) {
		this.actualLiteral = actualLiteral;
	}

	public int getIndiceSeguro() {
		return indiceSeguro;
	}

	public void setIndiceSeguro(int indiceSeguro) {
		this.indiceSeguro = indiceSeguro;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}


}
