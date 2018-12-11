package excepciones;

public class MovimientoInvalido extends Exception {
	private String mensaje;
	
	public MovimientoInvalido() {
		mensaje = "Movimiento invalido";
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
}
