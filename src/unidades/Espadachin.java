package unidades;

public class Espadachin extends Militar {
	
	// override costo
	
	protected int costo = 50;
	
	
	public Espadachin (int[] posicion) {
		
		this.espacioOcupado = posicion;
		this.danioAtaque= 25; // el -10 de bonus  en clase ataque
		this.radioAtaque = 1;
		this.vida = 100;
		
		cantidad += 1;
	}
	
	public void atacar() {
		System.out.println("Ataca a una unidad o edificio");
	}
	
	
}
