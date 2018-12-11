package excepciones;

public class UnidadAliada extends Exception {

	private String mensaje;
	
	public UnidadAliada() {
		mensaje = "No puede atacar una unidad aliada";
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
}
