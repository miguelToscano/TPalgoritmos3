package unidades;

import mapa.excepcionesMapa.casilleroEstaOcupado;
import excepciones.FueraDeRango;
import excepciones.NoEsElTurnoDelJugador;
import excepciones.NoEstaMontada;
import excepciones.PiezaDeshabilitadaEnTurno;
import excepciones.SuperaLimitePoblacional;
import excepciones.UnidadAliada;
import juego.*;
import mapa.Casillero;
import mapa.Mapa;

public class ArmaDeAsedio extends Militar {

	private boolean montada;
	public boolean enConstruccion;
	
	
	public ArmaDeAsedio (int fila, int columna, Mapa mapa) throws casilleroEstaOcupado {
		
		super (fila, columna, mapa);
		
		this.enConstruccion = false;
		this.montada = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;	
}
	
	public void ejecutarLogicaDeTurno() {
		System.out.println("Soy un arma de asedio");
		
		if (this.enConstruccion == true && this.montada == false) {
			this.enConstruccion = false;
			this.montada = true;
		}
		
		else if (this.enConstruccion == true && this.montada == true) {
			this.enConstruccion = false;
			this.montada = false;
		}
		
		this.yaAtaco = false;
	}
	
	public void setMontada(boolean value) {
		this.montada = true;
	}
	
	public ArmaDeAsedio() {
		super();
		this.montada = false;
		this.enConstruccion = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;
	}
	
	public void montar() {
		if (this.montada == false) {
			this.enConstruccion = true;
		}
	}
		
	public void desmontar() {
		if (this.montada == true) {
			this.enConstruccion = true;
		}
	}
	
	public ArmaDeAsedio (int fila, int columna, Mapa mapa, Jugador jugador) throws casilleroEstaOcupado, SuperaLimitePoblacional {
		
		super (fila, columna, mapa);
		
		this.enConstruccion = false;
		this.montada = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;
		this.jugador = jugador;
}

	public ArmaDeAsedio (Casillero casillero, Jugador jugador) throws casilleroEstaOcupado, SuperaLimitePoblacional {
	
		super (casillero, jugador);
		
		this.enConstruccion = false;
		this.montada = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;
}
	
	@Override
	public void atacar(Entidad objetivo)
			throws FueraDeRango, UnidadAliada, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno, NoEstaMontada {
		
		if (this.montada == false)
			throw new NoEstaMontada();
		
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

