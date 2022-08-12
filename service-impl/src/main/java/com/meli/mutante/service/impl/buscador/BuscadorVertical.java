package com.meli.mutante.service.impl.buscador;

import com.meli.mutante.dto.PosicionDto;
import com.meli.mutante.dto.ReclutadorDto;

public class BuscadorVertical extends BuscadorMutante {

	public BuscadorVertical(ReclutadorDto reclutador) {
		super(reclutador);
	}

	@Override
	protected void siguiente(PosicionDto posicion) {
		posicion.fila++;
		posicion.indiceBajo++;
		posicion.ultimoLiteral = posicion.actualLiteral;
		posicion.actualLiteral = posicion.dna[posicion.fila][posicion.columna];
	}

	@Override
	protected boolean existeSiguiente(PosicionDto posicion) {
		return posicion.fila + 1 <= posicion.indiceSeguro;
	}

	@Override
	public void buscarDnaMutante() {
		char[][] dna = reclutador.getDna();
		for (int column = 0; column < dna.length; column++) {
			boolean match = search(PosicionDto.in(dna, 0, column));
			if (match) {
				break;
			}
		}		
	}

	
	
	
	
}
