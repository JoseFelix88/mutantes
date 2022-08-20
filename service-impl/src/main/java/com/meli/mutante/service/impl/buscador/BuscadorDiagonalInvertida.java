package com.meli.mutante.service.impl.buscador;

import com.meli.mutante.dto.PosicionDto;
import com.meli.mutante.dto.ReclutadorDto;

public class BuscadorDiagonalInvertida extends BuscadorMutante {

	public BuscadorDiagonalInvertida(ReclutadorDto reclutador) {
		super(reclutador);
	}

	@Override
	protected void siguiente(PosicionDto posicion) {
		posicion.fila--;
		posicion.columna++;
		posicion.indiceBajo++;
		posicion.ultimoLiteral = posicion.actualLiteral;
		posicion.actualLiteral = posicion.dna[posicion.fila][posicion.columna];
	}

	@Override
	protected boolean existeSiguiente(PosicionDto posicion) {
		Integer inicio = posicion.indiceBajo;
		Integer disposicion = posicion.tamanio - inicio;
		return disposicion + posicion.secuencia >= reclutador.getFoundSecuence() && posicion.fila - 1 >= 0;
	}

	@Override
	public void buscarDnaMutante() {
		char[][] dna = reclutador.getDna();

		int indiceOfFila = dna.length - 1;
		int indiceOfColumn = 0;
		boolean isEncontrado = search(PosicionDto.in(dna, indiceOfFila, indiceOfColumn));
		if (isEncontrado) {
			return;
		}
		for (int row = 1; row <= dna.length - reclutador.getFoundSecuence(); row++) {
			isEncontrado = search(PosicionDto.in(dna, indiceOfFila - row, 0, row))
					|| search(PosicionDto.in(dna, indiceOfFila, row, row));
			if (isEncontrado) {
				break;
			}
		}

		

		
	}

}
