package excepciones;

public class NoEsElTurnoDelJugador extends Exception {
	private String mensaje;
	
	public NoEsElTurnoDelJugador() {
		mensaje = "No es el turno del jugador";
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
}
