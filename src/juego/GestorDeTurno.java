package juego;

import excepciones.HayUnGanador;

public class GestorDeTurno {
	
	protected Jugador jugadorDeTurno;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private int numeroTurno;
	
	public GestorDeTurno(Jugador jugadorA, Jugador jugadorB, int turno) {
		this.jugadorDeTurno=this.obtenerPrimerJugador();
		this.jugadorA=jugadorA;
		this.jugadorB=jugadorB;
		this.numeroTurno=turno;
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


}
