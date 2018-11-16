package unidades;

public abstract class Unidad extends Entidad {
	
	
	protected int turnosConstruccion = 1;

	protected int[] espacioOcupado; // fila columna
	
	public static int cantidad = 0;

	
	
//	Unidad(int [] posicion) {
//		this.espacioOcupado = posicion;
//	}
//	
//	Unidad(int fila, int columna, int vida, int costo) {
//		this.fila = fila;
//		this.columna = columna;
//		this.vida = vida;
//		this.costo = costo;
//	}
	
	public void mover(int[] deltaVec) {
		// check delta vec <=1
		this.espacioOcupado[0] += deltaVec[0];
		
		this.espacioOcupado[1] += deltaVec[1];
	}
	
	
	
	public void recibirDanio(int danio) {
		this.vida = this.vida - danio;
	}
}
