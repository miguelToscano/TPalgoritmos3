package edificios;

import java.util.ArrayList;

import unidades.ArmaDeAsedio;

public class Castillo extends Edificio
{
	
	ArrayList<ArmaDeAsedio> armasDeAsedio;
	
	Castillo (int[][] posiciones) {
		
		this.vida= 1000;
		this.construible = false;
		this.velocidadReparacion = 15;
		this.espacioOcupado = posiciones;

		armasDeAsedio = new ArrayList<ArmaDeAsedio>();
	}
	
	public void crearArmaDeAsedio(int[] posicion)
    {
		//check posicion esta en espacioOcupado
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(posicion);
		
		armasDeAsedio.add(unArmaDeAsedio);
	}
	
	public boolean tieneArmaDeAsedio() {
		return !this.armasDeAsedio.isEmpty();
	}
	
	public void atacarCircundantes()
    {
		
		int radioAtaque = 3;
		// atacar
		
	}
}