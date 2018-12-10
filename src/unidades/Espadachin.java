package unidades;

import excepciones.SuperaLimitePoblacional;
import juego.*;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.casilleroEstaOcupado;

public class Espadachin extends Militar {

	
	public Espadachin (int fila, int columna, Mapa mapa) throws casilleroEstaOcupado {
		
		super (fila, columna, mapa);
		this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;	
}

	public Espadachin (int fila, int columna, Mapa mapa, Jugador jugador) throws casilleroEstaOcupado, SuperaLimitePoblacional {
		
		super (fila, columna, mapa);
		this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;
        this.jugador = jugador;
        this.jugador.aumentarPoblacion(1);
	}
	
	@Override
	public void ejecutarLogicaDeTurno() {
		System.out.println("Soy un espadachin");
	}
	
	public Espadachin (Casillero casillero, Jugador jugador) throws casilleroEstaOcupado, SuperaLimitePoblacional
	{
	
		super (casillero,jugador);
		this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;
		
}

	public void atacar() {
		System.out.println("Ataca a una unidad o edificio");
	}

	
}
