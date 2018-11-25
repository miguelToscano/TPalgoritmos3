package unidades;
import excepciones.*;
import mapa.*;
import mapa.excepcionesMapa.casilleroLleno;

public abstract class Militar extends Unidad
{
	protected int danioAUnidades;
	protected int danioAEdificios;
	protected int radioAtaque;

   // abstract void atacar();
    
    public Militar (int fila, int columna, Mapa mapa) throws casilleroLleno {
    		
    		super (fila, columna, mapa);
    		
    	
    }
	
    public Militar (Casillero casillero) throws casilleroLleno {
    	
    	super (casillero);
    }
    
    
    
    public void atacar (Entidad objetivo) throws FueraDeRango, UnidadAliada
    {
    	if (! this.estaEnRango ( objetivo)) {
    		 throw new FueraDeRango();
    	}
    	//limitar turno
    	objetivo.recibirDanio(this.danioAUnidades);
    }
    
    
    public boolean estaEnRango ( Entidad objetivo) {
    		
    	return objetivo.estaEnRango(this.radioAtaque, this.casilleroOcupado);
    	}
    	
   

}
//    
//    public void atacar (Edificio objetivo) throws FueraDeRango, UnidadAliada
//    {
//    	if (! this.estaEnRango (radioAtaque, objetivo)) {
//   		 throw new FueraDeRango();
//   	}
//   	//limitar turno
//    	objetivo.recibirDanio(this.danioAUnidades);
//    }

