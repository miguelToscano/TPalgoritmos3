package edificios;

import java.util.ArrayList;

import unidades.ArmaDeAsedio;

public class Castillo extends Edificio {
	
	ArrayList<ArmaDeAsedio> armasDeAsedio;
	
	Castillo() {
		super();
		
		armasDeAsedio = new ArrayList<ArmaDeAsedio>();
	}
	
	public void crearArmaDeAsedio() {
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio();
		
		armasDeAsedio.add(unArmaDeAsedio);
	}
	
	public boolean tieneArmaDeAsedio() {
		return !this.armasDeAsedio.isEmpty();
	}
}
