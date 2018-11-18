package edificios;

import unidades.Entidad;
import mapa.Caja;

public abstract class Edificio extends Entidad
{

	protected Caja cajaOcupada;

	protected int velocidadReparacion;
	
	public void reparar()
	{
		vida += velocidadReparacion;
	}

	
}
