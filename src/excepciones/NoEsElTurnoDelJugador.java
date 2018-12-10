package excepciones;

public class NoEsElTurnoDelJugador extends Exception {

	
	public NoEsElTurnoDelJugador ()
{
		super ("No puede ejecutar acciones, espere su turno.");
}
}