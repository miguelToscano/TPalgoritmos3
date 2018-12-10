package excepciones;

public class MovimientoInvalido extends Exception {

	public MovimientoInvalido () {
		super("Movimiento Invalido. Verificar que el casillero este a distancia uno y no este ocupado.");
	}
}
