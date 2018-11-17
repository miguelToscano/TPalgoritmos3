package unidades;

public abstract class Entidad {

	protected int vida = 0;
	
	protected int costo = 0;
	
	protected boolean construible = true;
	
	 protected int turnosConstruccion = 3;
	
	 protected int[][] espacioOcupado; // Matriz de espacios ocupados.
	
	 
	 public int getVida() {
		return this.vida;
	}
	
	 public int getCosto() {
		return this.costo;
	}
	
	 public int getTurnosConstruccion() {
		return this.turnosConstruccion;
	}
 
	public boolean estaVivo () {
		return (this.vida > 0 );
	}
	
	
	 
 }