package excepciones;

public class SuperaLimitePoblacional extends Exception {

	private String mensaje;
	
	public SuperaLimitePoblacional() {
		mensaje = "Ya se alcanzo el limite de poblacion";
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
}
