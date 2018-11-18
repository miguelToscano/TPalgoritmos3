package unidades;
import mapa.*;

public abstract class Militar extends Unidad
{
	protected int danioAUnidades;
	protected int danioAEdificios;
	protected int radioAtaque;

    abstract void atacar();
    
    public Militar (int fila, int columna, Mapa mapa) {
    		
    		super (fila, columna, mapa);
    		
    	
    }
	
    public Militar (Casillero casillero) {
    	
    	super (casillero);
    }
}
