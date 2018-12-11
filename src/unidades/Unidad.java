package unidades;

import excepciones.MovimientoInvalido;
import excepciones.NoEsElTurnoDelJugador;
import excepciones.PiezaDeshabilitadaEnTurno;
import excepciones.SuperaLimitePoblacional;
import juego.Jugador;
import juego.Turno;
import mapa.Casillero;
import mapa.Mapa;
import mapa.Mapeable;
import mapa.excepcionesMapa.DistanciaInvalida;
import mapa.excepcionesMapa.casilleroEstaOcupado;

public abstract class Unidad extends Entidad

{
    public Casillero casilleroOcupado;
	private static int cantidad = 0;
	protected Turno turno;
	public boolean seMovio;

	//Constructores
	
	public Unidad()
    {
	    this.turnosConstruccion = 1;
	    this.cantidad++;
	    this.seMovio = false;
	}
	
	
	//Con coordenadas 
	public Unidad (int fila, int columna, Mapa mapa) throws casilleroEstaOcupado
    {
		Casillero casillero = mapa.obtenerCasillero(fila, columna);
    	this.ubicarEn(casillero);
    	this.turnosConstruccion = 1;
    	turno = new Turno();
    	this.cantidad++;
    	this.seMovio = false;

     }
	
	public abstract void ejecutarLogicaDeTurno();
	
	
	public Unidad (Casillero casillero)  throws casilleroEstaOcupado
    {
		this.ubicarEn(casillero);
		this.turnosConstruccion = 1;
    	turno = new Turno();
    	this.seMovio = false;
		this.cantidad++;

     }
	
	//con casillero y jugador
	public Unidad (Casillero casillero, Jugador jugador)  throws casilleroEstaOcupado
    {
		this.ubicarEn(casillero);
		this.turnosConstruccion = 1;
		this.jugador = jugador;
    	turno = new Turno();
    	this.seMovio = false;
		this.cantidad++;

     }
	
	public Casillero obtenerCasilleroOcupado() {
		return this.casilleroOcupado;
	}
	
	public void mover(Casillero casillero)throws MovimientoInvalido, casilleroEstaOcupado, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno, DistanciaInvalida {
	
			
//			this.jugador.assertTurno();
			this.turno.assertDisponibilidad();
			this.casilleroOcupado.assertDistancia(1,casillero);
			if (casillero.estaOcupado()) throw new casilleroEstaOcupado();
			this.casilleroOcupado.vaciar();
			this.ubicarEn(casillero);
			this.turno.finalizarAccion();
		
	}
	
	public void habilitar() {
		this.turno.habilitar();
	}
//	
//	public void deshabilitar() {
//		this.habilitada=false;
//	}
	
	public void recibirDanio( int danioUnidades, int danioEdificios)
	{
		this.vida = this.vida - danioUnidades;
		if (!this.estaVivo()) {
			this.vida = 0;
			this.matar();
		}
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
