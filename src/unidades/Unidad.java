package unidades;

import mapa.*;
import excepciones.*;
import juego.*;

import mapa.excepcionesMapa.casilleroEstaOcupado;

public abstract class Unidad extends Entidad

{
    protected Casillero casilleroOcupado;
	private static int cantidad = 0;
	private boolean habilitada=false;

	//Constructores
	
	public Unidad()
    {
	    this.turnosConstruccion = 1;
	    this.cantidad++;
	}
	
	
	//Con coordenadas 
	public Unidad (int fila, int columna, Mapa mapa) throws casilleroEstaOcupado
    {
		Casillero casillero = mapa.obtenerCasillero(fila, columna);
    	this.ubicarEn(casillero);
    	this.turnosConstruccion = 1;
    	this.cantidad++;

     }
	
	
	public Unidad (Casillero casillero)  throws casilleroEstaOcupado
    {
		this.ubicarEn(casillero);
		this.turnosConstruccion = 1;
		this.cantidad++;

     }
	
	//con casillero y jugador
	public Unidad (Casillero casillero, Jugador jugador)  throws casilleroEstaOcupado,superaLimitePoblacional
    {
		this.ubicarEn(casillero);
		this.turnosConstruccion = 1;
		this.jugador = jugador;
		this.jugador.aumentarPoblacion(1);
		this.cantidad++;

     }
	
	public void mover(Casillero casillero)throws casilleroEstaOcupado, NoEsElTurnoDelJugador, YaMovioEstaPieza {
		if (jugador.esTuTurno()) {
			if(this.habilitada) {
				this.casilleroOcupado.vaciar();
				//check distancias, movimiento posible
				this.ubicarEn(casillero);
				this.deshabilitar();
			}else {
				throw new YaMovioEstaPieza();
			}
		} else {
			throw new NoEsElTurnoDelJugador();
		}
	}
	
	public void habilitar() {
		this.habilitada=true;
	}
	
	public void deshabilitar() {
		this.habilitada=false;
	}
	

	public void ubicarEn(Mapeable mapeable) throws casilleroEstaOcupado
    {
    	Casillero casillero = (Casillero)mapeable;
        if (casillero.estaOcupado())
        {
        	throw new casilleroEstaOcupado();
        }
		this.casilleroOcupado = casillero;
        casillero.cambiarContenido(this);
    }
	
	public boolean estaEnRango (int rango, Casillero casillero) {
		
			if	(Math.abs(this.casilleroOcupado.getFila() - casillero.getFila()) > rango  || Math.abs(this.casilleroOcupado.getColumna() - casillero.getColumna()) > rango )
				return false;
			return true;
	}
	
	public void matar() {
		
		this.vida = 0;
		this.jugador.reducirPoblacion(1);
		this.cantidad--;
	}

	/*public boolean puedoColocar(int fila, int columna,Mapa mapa) throws casilleroEstaOcupado
	{
		return mapa.puedoColocarUnidad(fila,columna);
	}

	public boolean puedoColocar(Casillero casillero) throws casilleroEstaOcupado
	{
		boolean puedoColocar=true;
		if(casillero.estaOcupado())
		{
			throw new casilleroEstaOcupado();
		}
		return puedoColocar;
	}
	*/
	
}
