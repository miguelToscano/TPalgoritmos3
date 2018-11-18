package edificios;

import java.util.ArrayList;
import unidades.*;

public class PlazaCentral extends Edificio {

	private ArrayList<Aldeano> aldeanos;
	
	PlazaCentral() {
		
		this.aldeanos = new ArrayList<Aldeano>();
		this.vida = 450;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 25;
	}
	
	public void crearAldeano(int[] posicion) {
		
		Aldeano unAldeano = new Aldeano();
		
		this.aldeanos.add(unAldeano);
	}
	
	// Funcion solo para que pase las pruebas
	public boolean tieneAldeano() {
		return this.aldeanos.size() > 0;
	}
}
