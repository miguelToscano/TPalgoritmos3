package unidades;

import mapa.Mapeable;
import mapa.Casillero;
import mapa.Mapa;

public abstract class Unidad extends Entidad
{
    protected Casillero casilleroOcupado;
	public static int cantidad = 0;

	//Constructores
	
	public Unidad() {
	
	}
	
	//Con coordenadas 
	public Unidad (int fila, int columna, Mapa mapa)   
    {
        this.turnosConstruccion = 1;
        mapa.cambiarContenidoDeCasillero(fila, columna, this);
        this.casilleroOcupado = mapa.obtenerCasillero(fila,columna);
        
     }
	
	//con casillero 
	
	public Unidad (Casillero casillero)   
    {
        this.turnosConstruccion = 1;
        casillero.cambiarContenido(this);
        this.casilleroOcupado = casillero;
        
     }
	
	public void mover(Casillero casillero) {
		
		this.casilleroOcupado.vaciar();
		//check distancias, movimiento posible
		this.casilleroOcupado = casillero;
		casillero.cambiarContenido(this);
		
	}
	
	
	
	public void recibirDanio(int danio) {
		
		this.vida = this.vida - danio;
	}

	public void ubicar(Mapeable casillero)
    {
        this.casilleroOcupado = (Casillero)casillero;
    }
}
