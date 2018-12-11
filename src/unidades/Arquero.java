package unidades;

import mapa.excepcionesMapa.casilleroEstaOcupado;
import excepciones.FueraDeRango;
import excepciones.NoEsElTurnoDelJugador;
import excepciones.PiezaDeshabilitadaEnTurno;
import excepciones.SuperaLimitePoblacional;
import excepciones.UnidadAliada;
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

	public Arquero() {
		super();
		this.danioAEdificios = 10;
		this.danioAUnidades = 15;
		this.radioAtaque = 3;
		this.vida = 75;
		this.costo = 75;
	}
	
	public Arquero (int fila, int columna, Mapa mapa, Jugador jugador)throws casilleroEstaOcupado{
		
		super (fila, columna, mapa);
		
		this.danioAEdificios = 10;
		this.danioAUnidades = 15;
		this.radioAtaque = 3;
		this.vida = 75;
		this.costo = 75;
		this.jugador = jugador;
	}
	
	@Override
	public void ejecutarLogicaDeTurno() {
		this.yaAtaco = false;
	}
	
	public Arquero (Casillero casillero, Jugador jugador) throws casilleroEstaOcupado {
	
	super (casillero,  jugador);
	
	this.danioAEdificios = 10;
	this.danioAUnidades = 15;
	this.radioAtaque = 3;
	this.vida = 75;
	this.costo = 75;
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
	
//	public void atacar (Entidad objetivo) throws FueraDeRango, UnidadAliada, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno
//    {
//    	// estos metodos lanzan la excepcion correspondiente, asi no esta lleno de ifs
//    
//    	//this.jugador.assertTurno();  //es turno del jugador del cual es la nuidad
//		this.turno.assertDisponibilidad(); // la unidad no se movio anteriormente
//		this.assertUnidadEnemiga(objetivo); // la unidad objetivo a atacar no es aliada
//		
//    	if (! this.estaEnRango ( objetivo)) {
//    		 throw new FueraDeRango();
//    	}
//    	objetivo.recibirDanio(this.danioAUnidades,this.danioAEdificios);
////    	this.turno.finalizarAccion();
//    }

}
