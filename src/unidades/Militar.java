package unidades;
import excepciones.CasilleroLleno;
import mapa.*;

public abstract class Militar extends Unidad
{
	protected int danioAUnidades;
	protected int danioAEdificios;
	protected int radioAtaque;

    abstract void atacar();
    
    public Militar (int fila, int columna, Mapa mapa) throws CasilleroLleno {
    		
    		super (fila, columna, mapa);
    		
    	
    }
	
    public Militar (Casillero casillero) throws CasilleroLleno {
    	
    	super (casillero);
    }
}
