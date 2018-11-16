package fiuba.algo3.ejemplo1;

import java.util.ArrayList;

public class PlazaCentral extends Edificio {

	private ArrayList<Aldeano> aldeanos;
	
	PlazaCentral() {
		
		super();
		this.aldeanos = new ArrayList<Aldeano>();
		this.vida = 450;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.tamanio = 4;
		this.velocidadReparacion = 25;
	}
	
	public void crearAldeano() {
		
		Aldeano unAldeano = new Aldeano();
		
		this.aldeanos.add(unAldeano);
	}
	
	// Funcion solo para que pase las pruebas
	public boolean tieneAldeano() {
		return this.aldeanos.size() > 0;
	}
}
