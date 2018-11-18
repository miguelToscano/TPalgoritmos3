package edificios;

import unidades.Entidad;

public abstract class Edificio extends Entidad {

	
	protected int velocidadReparacion;
	
	public void reparar() {
		vida += velocidadReparacion;
	}

	
}
