package excepciones;

public class superaLimitePoblacional extends Exception {

	public superaLimitePoblacional () {
		super("No se puede crear la unidad, no hay espacio poblacional. ");
	}
}
