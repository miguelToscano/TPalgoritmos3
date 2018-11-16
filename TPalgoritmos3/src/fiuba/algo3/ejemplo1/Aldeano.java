package fiuba.algo3.ejemplo1;

public class Aldeano extends Unidad {

	Aldeano() {
		super(0,0);
	}
	
	Aldeano(int fila, int columna) {
		super(fila, columna);
	}
	
	Aldeano(int fila, int columna, int vida) {
		super(fila, columna);
		// TODO Auto-generated constructor stub
	}

	public void construirEdificio() {
		System.out.println("Construye un edificio");
	}
	
	public void repararEdificio() {
		System.out.println("Repara un edificio");
	}
	
	public void recolectarOro() {
		System.out.println("Recolecta oro");
	}
}
