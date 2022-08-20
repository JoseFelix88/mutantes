package com.meli.mutante.service.impl.processor;

import java.util.LinkedList;
import java.util.List;

import com.meli.mutante.dto.ReclutadorDto;
import com.meli.mutante.service.impl.buscador.BuscadorDiagonal;
import com.meli.mutante.service.impl.buscador.BuscadorDiagonalInvertida;
import com.meli.mutante.service.impl.buscador.BuscadorHorizontal;
import com.meli.mutante.service.impl.buscador.BuscadorMutante;
import com.meli.mutante.service.impl.buscador.BuscadorVertical;

public class BuscadorProcessor {

	private ReclutadorDto reclutador;
	List<BuscadorMutante> itemsToProcess = new LinkedList<>();
	
	public BuscadorProcessor(char[][] dnaSecuence, Integer foundSecuence, Integer countSecuenceFind) {
		reclutador = new ReclutadorDto();
		reclutador.setDna(dnaSecuence);
		reclutador.setFoundSecuence(foundSecuence);
		reclutador.setCountSecuenceFind(countSecuenceFind);
		
		cargarBuscador();
		reclutador = null;
	}
	
	private void cargarBuscador() {
		BuscadorMutante horizontal = new BuscadorHorizontal(reclutador);
		BuscadorMutante vertical = new BuscadorVertical(reclutador);
		BuscadorMutante diagonal = new BuscadorDiagonal(reclutador);
		BuscadorMutante diagonalInvertida = new BuscadorDiagonalInvertida(reclutador);

		addItems(horizontal);
		addItems(vertical);
		addItems(diagonal);
		addItems(diagonalInvertida);
	}

	private void addItems(BuscadorMutante buscadorMutante) {
		this.itemsToProcess.add(buscadorMutante);
	}
	

	public boolean existMutante() {
		boolean existeDnaMutante = false;
		for (BuscadorMutante mutante : itemsToProcess) {
			mutante.buscarDnaMutante();
			existeDnaMutante = mutante.existeDnaMutante();
			if (existeDnaMutante)
				break;
		}

		return existeDnaMutante;
	}
	
	
}
