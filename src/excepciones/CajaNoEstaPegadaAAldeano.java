package excepciones;

public class CajaNoEstaPegadaAAldeano extends Exception
{
	private String mensaje;
	
	public CajaNoEstaPegadaAAldeano() {
		mensaje = "La posicion donde se quiere construir esta fuera de alcance";
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
}
