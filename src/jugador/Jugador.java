package jugador;

import edificios.Castillo;
import excepciones.*;
//Cada jugador comienza con una plaza central y un castillo. No es posible construir un castillo. Sólo 
// existirá el que es asignado al empezar la partida. Sí es posible construir plazas centrales y cuarteles sin límite.
//
//Cada jugador comienza la partida con 3 aldeanos y 100 de oro
//
//Los jugadores inician en extremos opuestos del mapa.
//
//El límite de población es 50 (para cada jugador, es decir, 100 en total). Cada unidad del jugador ocupa 1 lugar de población. Los edificios no ocupan lugar de población.


public class Jugador {
	
	final static int ORO_INICIAL = 100;
	final static int LIMITE_POBLACION = 50;	
	
	protected int oro;
	protected int poblacion;

	public Jugador() {
		
		this.oro = ORO_INICIAL;
		this.poblacion = 0;
	}
	
	public int obtenerPoblacion() {
		
		return this.poblacion;
	}
	
	// Esta funcion es solo para usarla en los Test
	public void establecerPoblacion(int nuevaPoblacion) {
		
		this.poblacion = nuevaPoblacion;
	}
	
	public void aumentarPoblacion(int cantidad) throws SuperaLimitePoblacional {
		
		if (this.poblacion + cantidad > LIMITE_POBLACION)
			throw new SuperaLimitePoblacional();
		
		this.poblacion += cantidad;
	}
	
	public void reducirPoblacion(int cantidad) {
		
		this.poblacion -= cantidad;
	}
	
	public int obtenerOro() {
		
		return this.oro;
	}
	
	public void sumarOro(int oro) {
		
		this.oro += oro;
	}

	public void asignarCastillo(Castillo castilloSuperior) {
		// TODO Auto-generated method stub
	}
}
