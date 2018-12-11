package excepciones;

public class NoEstaMontada extends Exception {

	String mensaje;
	
	public NoEstaMontada() {
		this.mensaje = "El arma de asedio no puede atacar si no esta montada";
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
}
