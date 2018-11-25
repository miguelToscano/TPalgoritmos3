package unidades;

import mapa.*;
import excepciones.*
;public abstract class Unidad extends Entidad

{
    protected Casillero casilleroOcupado;
	private static int cantidad = 0;

	//Constructores
	
	public Unidad()
    {
	    this.turnosConstruccion = 1;
	    this.cantidad++;
	}
	
	//Con coordenadas 
	public Unidad (int fila, int columna, Mapa mapa) throws CasilleroLleno  
    {
        this.turnosConstruccion = 1;
        Casillero casillero = mapa.obtenerCasillero(fila,columna);
        this.ubicar(casillero);
	    this.cantidad++;

        
     }
	
	//con casillero
	public Unidad (Casillero casillero)  throws CasilleroLleno  
    {
        this.turnosConstruccion = 1;
        this.ubicar(casillero);
	    this.cantidad++;

        
     }
	
	public void mover(Casillero casillero)throws CasilleroLleno {
		
		this.casilleroOcupado.vaciar();
		//check distancias, movimiento posible
		this.ubicar(casillero);
	}
	
	
	
	public void recibirDanio(int danio) {
		
		this.vida = this.vida - danio;
		if (vida <= 0 ) {
			//matar unidad
			this.cantidad--;
		}
	}

	public void ubicar(Mapeable mapeable) throws CasilleroLleno
    {
        Casillero casillero = (Casillero) mapeable; 
        if (casillero.estaOcupado()) {
        	throw new CasilleroLleno();
        }
		this.casilleroOcupado = casillero;
        casillero.cambiarContenido(this);
    }
	
	public boolean estaEnRango (int rango, Casillero casillero) {
		
			if	(Math.abs(this.casilleroOcupado.getFila() - casillero.getFila()) > rango  || Math.abs(this.casilleroOcupado.getColumna() - casillero.getColumna()) > rango )
				return false;
			return true;
	}
	
}
