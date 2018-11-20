package edificios;

import unidades.Entidad;
import mapa.*;

public abstract class Edificio extends Entidad {

	protected Caja cajaOcupada;
	
	protected Casillero puntoRally; // aca se crean las unidades

	protected int velocidadReparacion;
	
	public Edificio ()
    {
		
	}

	public Edificio (Casillero casilleroInicial, Mapa mapa) throws casilleroInvalido
    {

		this.cajaOcupada = this.fijarCaja(casilleroInicial, mapa);
		
	}
	
	public void settearPuntoRally ()
    {
		puntoRally = cajaOcupada.obtenerCasillero(0);

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
}
