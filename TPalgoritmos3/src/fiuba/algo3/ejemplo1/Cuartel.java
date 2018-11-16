package fiuba.algo3.ejemplo1;

import java.util.ArrayList;

public class Cuartel {

	private ArrayList<Espadachin> espadachines;
	
	private ArrayList<Arquero> arqueros;
	
	Cuartel() {
		
		super();
		espadachines = new ArrayList<Espadachin>();
		arqueros = new ArrayList<Arquero>();
	}
	
	public void crearEspadachin() {
		
		Espadachin unEspadachin = new Espadachin();
		
		this.espadachines.add(unEspadachin);
	}
	
	public void crearArquero() {
		
		Arquero unArquero = new Arquero();
		
		this.arqueros.add(unArquero);
	}
	
	public boolean tieneEspadachin() {
		return this.espadachines.size() > 0;
	}
	
	public boolean tieneArquero() {
		return this.arqueros.size() > 0;
	}
}
