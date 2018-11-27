package unidades;

import mapa.Mapeable;
import mapa.Casillero;
import mapa.excepcionesMapa.*;
import juego.*;
public abstract class Entidad
{
   	protected int vida;
   	protected static int vidaCompleta;
	protected int costo;
	protected boolean construible;
	protected int turnosConstruccion;
	protected Jugador jugador;
	
    public Entidad()
    {
        this.construible=true;//??
    }
	 
    public int getVida()
    {
		return this.vida;
	}
	
	public int getCosto()
    {
		return this.costo;
	}
	
	public int getTurnosConstruccion()
    {
		return this.turnosConstruccion;
	}
 
	public void recibirDanio(int danio) {
		
		this.vida = this.vida - danio;
		if (vida <= 0 ) {
			this.matar();
		}
	}
	
	public void establecerJugador(Jugador jugador) {
		
		this.jugador = jugador;
	}
	
	
	
	public boolean estaVivo ()
    {
		return (this.vida > 0 );
	}
	public abstract void matar();
	public abstract boolean estaEnRango (int rango, Casillero casillero);

	public abstract void ubicarEn(Mapeable mapeable) throws casilleroEstaOcupado, cajaEstaOcupada;
 }
