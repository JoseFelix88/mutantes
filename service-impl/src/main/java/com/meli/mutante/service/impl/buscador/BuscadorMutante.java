package com.meli.mutante.service.impl.buscador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import com.meli.mutante.dto.PosicionDto;
import com.meli.mutante.dto.ReclutadorDto;

public abstract class BuscadorMutante {

	private static final Logger log = LoggerFactory.getLogger(BuscadorMutante.class);

	protected ReclutadorDto reclutador;

	public BuscadorMutante(ReclutadorDto reclutador) {
		super();
		this.reclutador = reclutador;
	}

	public boolean search(PosicionDto posicion) {
		log.info("********* Buscando mutantes... *********");
		char literalActual = posicion.getDna()[posicion.getFila()][posicion.getColumna()];
		posicion.secuencia = 1;
		boolean existeDnaMutante = false;
		while (existeSiguiente(posicion)) {
			siguiente(posicion);
			if (literalActual != posicion.getActualLiteral()) {
				posicion.secuencia = 1;
				literalActual = posicion.getActualLiteral();
			} else if (++posicion.secuencia >= reclutador.getFoundSecuence()) {
				this.siguienteDnaFound();
					log.info("********* Mutante {} encontrado *********", posicion.secuencia);
				existeDnaMutante = existeDnaMutante();
				return existeDnaMutante;
			}
		}

		return existeDnaMutante;
	}

	public boolean existeDnaMutante() {
		Integer found = !ObjectUtils.isEmpty(reclutador.getFound()) ? reclutador.getFound()
				: reclutador.getFoundSecuence();
		return found >= reclutador.getCountSecuenceFind();
	}

	protected void siguienteDnaFound() {
		reclutador.setFound(reclutador.getCountSecuenceFind() + 1);
	}

	protected abstract void siguiente(PosicionDto gps);

	protected abstract boolean existeSiguiente(PosicionDto gps);
	
	public abstract void buscarDnaMutante();

}
