package unidades;

import excepciones.FueraDeRango;
import excepciones.NoEsElTurnoDelJugador;
import excepciones.PiezaDeshabilitadaEnTurno;
import excepciones.SuperaLimitePoblacional;
import excepciones.UnidadAliada;
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

	public Espadachin() {
		super();
		this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;
	}
	
	public Espadachin (int fila, int columna, Mapa mapa, Jugador jugador) throws casilleroEstaOcupado {
		
		super (fila, columna, mapa);
		this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;
        this.jugador = jugador;
	}
	
	@Override
	public void ejecutarLogicaDeTurno() {
		System.out.println("Soy un espadachin");
	}
	
	public Espadachin (Casillero casillero, Jugador jugador) throws casilleroEstaOcupado
	{
	
		super (casillero,jugador);
		this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;
}

	public void atacar(Entidad objetivo) throws FueraDeRango, UnidadAliada, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno
	{
		if (this.yaAtaco == true) {
			throw new PiezaDeshabilitadaEnTurno();
		}
		
		this.assertUnidadEnemiga(objetivo);
		
		if (!this.estaEnRango(objetivo)) {
			throw new FueraDeRango();
		}
		
		objetivo.recibirDanio(this.danioAUnidades, this.danioAEdificios);
		
		this.yaAtaco = true;
	}

	
}
