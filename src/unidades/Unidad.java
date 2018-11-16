package unidades;

public class Unidad {
	
	protected int vida;
	
	protected int costo;
	
	protected int fila;
	
	protected int columna;

	Unidad() {
		this.vida = 0;
		this.costo = 0;
		this.fila = 0;
		this.columna = 0;
	}
	
	Unidad(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}
	
	Unidad(int fila, int columna, int vida, int costo) {
		this.fila = fila;
		this.columna = columna;
		this.vida = vida;
		this.costo = costo;
	}
	
	public void mover(int deltaY, int deltaX) {
		this.fila += deltaY;
		this.columna += deltaX;
	}
	
	public int getFila() {
		return this.fila;
	}
	
	public int getColumna() {
		return this.columna;
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
