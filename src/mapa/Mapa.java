package mapa;

public class Mapa {

	private int filas;
	
	private int columnas;
	
	Mapa(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
	}
	
	public int getFilas() {
		return this.filas;
	}
	
	public int getColumnas() {
		return this.columnas;
	}
}
