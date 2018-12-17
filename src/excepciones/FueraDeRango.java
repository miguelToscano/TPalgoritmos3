package excepciones;

public class FueraDeRango extends Exception {

	private String mensaje;
	
	public FueraDeRango() {
		mensaje = "Fuera de rango";
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
}
