package excepciones;

public class PiezaDeshabilitadaEnTurno extends Exception{

	private String mensaje;
	
	public PiezaDeshabilitadaEnTurno() {
		mensaje = "La pieza esta inhabilitada por este turno";
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
}
