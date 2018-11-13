package fiuba.algo3.ejemplo1;

public class Espadachin extends Unidad {

	private int danioUnidades;
	
	private int danioEdificios;
	
	Espadachin() {
		super(0, 0, 100);
		this.danioUnidades = 25;
		this.danioEdificios = 15;
	}
	
	public void atacar() {
		System.out.println("Ataca a una unidad o edificio");
	}
	
	
}
