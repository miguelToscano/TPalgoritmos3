package edificios;

import java.util.ArrayList;
import unidades.*;

public class Cuartel extends Edificio {

	private ArrayList<Militar> ejercito;
	
	//private ArrayList<Arquero> arqueros;
	
	Cuartel(int [][]posiciones) {
		
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vida = 250;
		this.espacioOcupado = posiciones;
		ejercito = new ArrayList<Militar>();
		//arqueros = new ArrayList<Arquero>();
	}
	
	public void crearEspadachin(int[] posicion) {
		
		Espadachin unEspadachin = new Espadachin(posicion);
		
		this.ejercito.add(unEspadachin);
	}
	
	public void crearArquero(int[] posicion) {
		
		Arquero unArquero = new Arquero(posicion);
		
		this.ejercito.add(unArquero);
	}
	
	public boolean tieneEspadachin() {
		return this.ejercito.size() > 0;
	}
	
	public boolean tieneArquero() {
		return this.ejercito.size() > 0;
	}
}
