package unidades;

import mapa.excepcionesMapa.casilleroEstaOcupado;
import excepciones.superaLimitePoblacional;
import juego.*;
import mapa.Casillero;
import mapa.Mapa;

public class Arquero extends Militar
{
	public Arquero (int fila, int columna, Mapa mapa)throws casilleroEstaOcupado {
		
		super (fila, columna, mapa);
		
		this.danioAEdificios = 10;
		this.danioAUnidades = 15;
		this.radioAtaque = 3;
		this.vida = 75;
		this.costo = 75;
		
	}

	public Arquero (int fila, int columna, Mapa mapa, Jugador jugador)throws casilleroEstaOcupado, superaLimitePoblacional {
		
		super (fila, columna, mapa);
		
		this.danioAEdificios = 10;
		this.danioAUnidades = 15;
		this.radioAtaque = 3;
		this.vida = 75;
		this.costo = 75;
		this.jugador = jugador;
		this.jugador.aumentarPoblacion(1);
	}
	
	public Arquero (Casillero casillero, Jugador jugador) throws casilleroEstaOcupado,superaLimitePoblacional {
	
	super (casillero,  jugador);
	
	this.danioAEdificios = 10;
	this.danioAUnidades = 15;
	this.radioAtaque = 3;
	this.vida = 75;
	this.costo = 75;
}
	
	
	public void atacar()
		{
			System.out.println("Ataca a una unidad o edificio");
		}

}
