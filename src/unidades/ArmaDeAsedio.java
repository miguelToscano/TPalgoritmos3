package unidades;

import mapa.excepcionesMapa.casilleroEstaOcupado;
import excepciones.SuperaLimitePoblacional;
import juego.*;
import mapa.Casillero;
import mapa.Mapa;

public class ArmaDeAsedio extends Militar {

	private boolean montada;

	
	
	public ArmaDeAsedio (int fila, int columna, Mapa mapa) throws casilleroEstaOcupado {
		
		super (fila, columna, mapa);
		
		this.montada = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;	
}
	
	public void ejecutarLogicaDeTurno() {
		System.out.println("Soy un arma de asedio");
	}
	
	public ArmaDeAsedio() {
		super();
		this.montada = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;
	}
	
	public ArmaDeAsedio (int fila, int columna, Mapa mapa, Jugador jugador) throws casilleroEstaOcupado, SuperaLimitePoblacional {
		
		super (fila, columna, mapa);
		
		this.montada = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;
		this.jugador = jugador;
}

	public ArmaDeAsedio (Casillero casillero, Jugador jugador) throws casilleroEstaOcupado, SuperaLimitePoblacional {
	
		super (casillero, jugador);
		
		this.montada = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;

}
	
	

    public void desmontar()
    {
        montada = false;
    }
    
    public void montar()
    {
        montada = true;
    }

		
}

