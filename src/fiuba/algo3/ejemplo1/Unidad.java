package fiuba.algo3.ejemplo1;

public class Unidad {
	
	protected int vida;
	
	protected int costo;
	
	protected int fila;
	
	protected int columna;

	Unidad() {
		
	}
	
	Unidad(int fila, int columna, int vida) {
		this.fila = fila;
		this.columna = columna;
		this.vida = vida;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public int getCosto() {
		return this.costo;
	}
	
	public void recibirDanio(int danio) {
		this.vida = this.vida - danio;
	}
}
