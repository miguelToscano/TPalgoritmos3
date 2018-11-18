package unidades;

public class Espadachin extends Militar {

	public Espadachin()
    {
        this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;
    }
	
	
	/*public Espadachin (int[] posicion) {
		
		this.espacioOcupado = posicion;
		this.danioAtaque= 25; // el -10 de bonus  en clase ataque
		cantidad += 1;
	}
	*/
	public void atacar() {
		System.out.println("Ataca a una unidad o edificio");
	}

	
}
