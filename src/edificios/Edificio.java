package edificios;

import unidades.Entidad;
import mapa.*;

public abstract class Edificio extends Entidad {

	protected Caja cajaOcupada;
	
	protected Casillero puntoRally; // aca se crean las unidades
	protected int velocidadReparacion;
	
	
	public Edificio () {
		
	}
	public Edificio (Casillero casilleroInicial, Mapa mapa) {
		
		this.cajaOcupada = this.obtenerCaja(casilleroInicial,mapa);

		
	}
	
	public void settearPuntoRally () {
		puntoRally = cajaOcupada.obtenerCasillero(1);
		//harcodeo el primer lugar, despues vemos donde las ponemos
		
	}
	
	public Caja obtenerCaja(Casillero casilleroInicial, Mapa mapa) {
		Caja caja = mapa.asignarCajaACasillero(casilleroInicial); // 4 para todos los edficios construibles
		return caja;
	}
	public void reparar()
	{
		vida += velocidadReparacion;
	}
	public Casillero getPuntoRally(){
		return this.puntoRally ;
	}
	
	public Caja obtenerEspacioOcupado()
	{
		return this.cajaOcupada;
	}
}
