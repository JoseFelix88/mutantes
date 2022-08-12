package com.meli.mutante.service.impl.buscador;

import com.meli.mutante.dto.PosicionDto;
import com.meli.mutante.dto.ReclutadorDto;

public class BuscadorDiagonal extends BuscadorMutante {

	public BuscadorDiagonal(ReclutadorDto reclutador) {
		super(reclutador);
	}

	@Override
	protected void siguiente(PosicionDto posicion) {
		posicion.fila++;
		posicion.columna++;
		posicion.indiceBajo++;
		posicion.ultimoLiteral = posicion.actualLiteral;
		posicion.actualLiteral = posicion.dna[posicion.fila][posicion.columna];		
	}

	@Override
	protected boolean existeSiguiente(PosicionDto posicion) {
		int index = posicion.indiceBajo;
		int disponible = posicion.tamanio - index;
		return disponible + posicion.secuencia >= reclutador.getFoundSecuence()
				&& Math.max(posicion.columna, posicion.fila) + 1 < posicion.tamanio;
	}

	@Override
	public void buscarDnaMutante() {
		char[][] dna = reclutador.getDna();

		boolean match = search(PosicionDto.in(dna, 0, 0));
		if (match) {
			return;
		}
		for (int row = 1; row <= dna.length - reclutador.getFoundSecuence(); row++) {
			match = search(PosicionDto.in(dna, row, 0, row)) || search(PosicionDto.in(dna, 0, row, row));
			if (match) {
				break;
			}
		}

	}

}
