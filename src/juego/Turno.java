package juego;

import excepciones.PiezaDeshabilitadaEnTurno;

public class Turno {
	
	private boolean habilitada;
	
	
	
	
	public Turno () {
		
		this.habilitada = true;
	}
	
	
	
	public void assertDisponibilidad() throws PiezaDeshabilitadaEnTurno {
		if (!habilitada) {
			throw new PiezaDeshabilitadaEnTurno();
		}
	}
	
	public void finalizarAccion() {
		
		habilitada = false;
	}
	
	public void habilitar() {
		
		habilitada = true;
	}
}
