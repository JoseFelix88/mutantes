package com.meli.mutante.service.impl.buscador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meli.mutante.dto.GpsDto;
import com.meli.mutante.dto.ReclutadorDto;

public abstract class BuscadorMutante {

	private static final Logger log = LoggerFactory.getLogger(BuscadorMutante.class);

	protected ReclutadorDto reclutador;

	public BuscadorMutante(ReclutadorDto reclutador) {
		super();
		this.reclutador = reclutador;
	}

	public boolean search(GpsDto gps) {
		log.info("********* Buscando mutantes... *********");
		char literalActual = gps.getDna()[gps.getFila()][gps.getColumna()];
		int index = 1;
		boolean existeDnaMutante = false;
		while (existeSiguiente(gps)) {
			siguiente(gps);
			if (literalActual != gps.getActualLiteral()) {
				index = 1;
				literalActual = gps.getActualLiteral();
			} else if (++index >= reclutador.getFoundSecuence()) {
				this.siguienteDnaFound();
					log.info("********* Mutante {} encontrado *********", index);
				existeDnaMutante = existeDnaMutante();
				return existeDnaMutante;
			}
		}

		return existeDnaMutante;
	}

	public boolean existeDnaMutante() {
		return reclutador.getFound() >= reclutador.getCountSecuenceFind();
	}

	protected void siguienteDnaFound() {
		reclutador.setFound(reclutador.getFound() + 1);
	}

	protected abstract void siguiente(GpsDto gps);

	protected abstract boolean existeSiguiente(GpsDto gps);
	
	public abstract void buscarDnaMutante();

}
