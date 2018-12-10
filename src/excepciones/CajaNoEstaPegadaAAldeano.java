package excepciones;

public class CajaNoEstaPegadaAAldeano extends Exception
{
	public CajaNoEstaPegadaAAldeano () {
		super ("Caja no esta Pegada al aldeano");
		
	}

	public CajaNoEstaPegadaAAldeano (String str) {
		super (str);
		
	}
}
