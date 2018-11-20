package unidades;

import excepciones.*;
import mapa.Casillero;
import mapa.Mapa;

public class Espadachin extends Militar {

	
	public Espadachin (int fila, int columna, Mapa mapa) throws CasilleroLleno {
		
		super (fila, columna, mapa);
		
		this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;
		
	
}

	public Espadachin (Casillero casillero) throws CasilleroLleno {
	
		super (casillero);
		
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
