package com.meli.mutante.service.impl.buscador;

import com.meli.mutante.dto.PosicionDto;
import com.meli.mutante.dto.ReclutadorDto;

public class BuscadorHorizontal extends BuscadorMutante {

	public BuscadorHorizontal(ReclutadorDto reclutador) {
		super(reclutador);
	}

	@Override
	protected void siguiente(PosicionDto posicion) {
		posicion.columna++;
		posicion.indiceBajo++;
		posicion.ultimoLiteral = posicion.actualLiteral;
		posicion.actualLiteral = posicion.dna[posicion.fila][posicion.columna];
	}

	@Override
	protected boolean existeSiguiente(PosicionDto gps) {
		return gps.columna + 1 <= gps.indiceSeguro;
	}

	@Override
	public void buscarDnaMutante() {
		char[][] dna = reclutador.getDna();
		for (int row = 0; row < dna.length; row++) {
			boolean exist = search(PosicionDto.in(dna, row, 0));
			if (exist) 
				break;
		}

	}

}
