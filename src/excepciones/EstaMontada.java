package excepciones;

public class EstaMontada extends Exception {

	String mensaje;
	
	public EstaMontada() {
		this.mensaje = "No se puede mover mientras esta montada";
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
}
