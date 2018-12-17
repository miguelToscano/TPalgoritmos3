package excepciones;

public class NoHaySuficienteOro extends Exception {
	private String mensaje;
	
	public NoHaySuficienteOro() {
		mensaje = "No tiene oro suficiente";
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
}
