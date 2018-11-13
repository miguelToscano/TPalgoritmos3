package fiuba.algo3.ejemplo1;

public class Edificio {

	protected int vida;
	
	protected int costo;
	
	protected int turnosConstruccion;
	
	protected int tamanio;
	
	protected int velocidadReparacion;
	
	Edificio() {
		
		this.vida = 0;
		this.costo = 0;
		this.turnosConstruccion = 0;
		this.tamanio = 0;
		this.velocidadReparacion = 0;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public int getCosto() {
		return this.costo;
	}
	
	public int getTurnosConstruccion() {
		return this.turnosConstruccion;
	}
	
	public int getTamanio() {
		return this.tamanio;
	}
}
