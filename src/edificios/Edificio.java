package edificios;

import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroInvalido;
import unidades.Entidad;
import mapa.*;

public abstract class Edificio extends Entidad {

	protected Caja cajaOcupada;
	
	protected Casillero puntoRally; // aca se crean las unidades

	protected int velocidadReparacion;
	
	protected boolean construido=false;

	public Edificio ()
    {

	}

	public Edificio (Casillero casilleroInicial, Mapa mapa) throws casilleroInvalido, cajaEstaOcupada
    {
    	if(this.puedoColocar(casilleroInicial,mapa))
		{
			this.cajaOcupada = this.fijarCaja(casilleroInicial, mapa);
		}
	}
	
	public void settearPuntoRally (Mapa mapa)
    {
		int puntoRallyFila = mapa.obtenerFilaInt(cajaOcupada.obtenerCasillero(0));
		int puntoRallyColumna = mapa.obtenerColumnaInt(cajaOcupada.obtenerCasillero(0))+ 2;
		
		// pongo el +2 ahi. La idea seria abrir un GUI que permita elegir el RP
		
		puntoRally =mapa.obtenerCasillero(puntoRallyFila, puntoRallyColumna);
		

	}
	
	private Caja fijarCaja(Casillero casilleroInicial, Mapa mapa) throws casilleroInvalido
    {
		return mapa.asignarCajaACasillero(casilleroInicial); // 4 para todos los edficios construibles
	}

	public void reparar()
	{
		this.vida += this.velocidadReparacion;
	}
	public Casillero getPuntoRally()
    {
		return this.puntoRally ;
	}
	
	public Caja obtenerEspacioOcupado()
	{
		return this.cajaOcupada;
	}
	
	public void mostrarConstruido() {
		this.construido=true;
	}
	
	public boolean estaEnRango (int rango, Casillero casillero) {
		
		for	(Casillero celda: this.cajaOcupada.getLista()) {
			if	(Math.abs(celda.getFila() - casillero.getFila()) > rango  || Math.abs(celda.getColumna() - casillero.getColumna()) > rango )
				return false;
		}
		return true;
	}


	public boolean puedoColocar(Casillero casillero,Mapa mapa) throws cajaEstaOcupada,casilleroInvalido
	{
		return mapa.puedoColocarEdificio(casillero);
	}
}
