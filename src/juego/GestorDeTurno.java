package juego;

public class GestorDeTurno {
	
	private Jugador jugadorDeTurno;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private int numeroTurno;
	
	public GestorDeTurno(Jugador jugadorA, Jugador jugadorB, int turno) {
		this.jugadorDeTurno=this.obtenerPrimerJugador();
		this.jugadorA=jugadorA;
		this.jugadorB=jugadorB;
		this.numeroTurno=turno;
	}
	
	public void finalizarTurno() {
		
		if (!this.hayUnGanador()) {
			numeroTurno++;
			jugadorDeTurno=this.obtenerJugadorSiguiente();
		}
	}
	
	public Jugador obtenerPrimerJugador() {
		// TODO Random algorithm
		return jugadorA;
	}
	
	public Jugador obtenerJugadorSiguiente() {
		if (jugadorDeTurno==jugadorA) {
			return jugadorB;
		} else {
			return jugadorA;
		}
	}
	
	private boolean hayUnGanador() {
		//TODO
		return false;
	}
	
	public int obtenerTurnoActual() {
		//TODO
		return this.numeroTurno;
	}


}
