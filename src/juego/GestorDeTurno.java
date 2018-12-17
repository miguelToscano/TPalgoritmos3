package juego;

import excepciones.HayUnGanador;

public class GestorDeTurno {
	
	protected Jugador jugadorDeTurno;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private int numeroTurno;
	
	public GestorDeTurno(Jugador jugadorA, Jugador jugadorB, int turno) {
		
		this.jugadorA=jugadorA;
		this.jugadorB=jugadorB;
		this.numeroTurno=turno;
		this.jugadorDeTurno=this.obtenerPrimerJugador();
	}
	
	public Jugador obtenerJugadorActual() {
		return this.jugadorDeTurno;
	}
	
	public void finalizarTurno() throws HayUnGanador {
		
		if (!this.hayUnGanador()) {
			numeroTurno++;
			jugadorDeTurno.deshabilitar();
			jugadorDeTurno=this.obtenerJugadorSiguiente();
			jugadorDeTurno.habilitar();
		} else {
			throw new HayUnGanador();
		}
	}
	
	public Jugador obtenerPrimerJugador() {
		double numeroRandom = Math.random();
		if(numeroRandom<0.5){
			return jugadorA;
		}else{
			return jugadorB;
		}
	}
	
	public Jugador obtenerJugadorSiguiente() {
		if (jugadorDeTurno==jugadorA) {
			return jugadorB;
		} else {
			return jugadorA;
		}
	}
	
	public boolean hayUnGanador()
	{
		return (jugadorA.perdioLaPartida() || jugadorB.perdioLaPartida());
	}
	
	public int obtenerTurnoActual() {
		
		return this.numeroTurno;
	}
	
	public Jugador obtenerGanador() {
		Jugador ganador=null;
		if (jugadorA.perdioLaPartida()) {
			ganador=jugadorB;
		} else if (jugadorB.perdioLaPartida()){
			ganador=jugadorA;
		}
		return ganador;
	}


}
