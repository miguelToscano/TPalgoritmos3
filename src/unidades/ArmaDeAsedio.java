package unidades;

import mapa.Casillero;
import mapa.Mapa;

public class ArmaDeAsedio extends Militar {

	private boolean montada;

	
	
	public ArmaDeAsedio (int fila, int columna, Mapa mapa) {
		
		super (fila, columna, mapa);
		
		this.montada = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;

		
	
}

	public ArmaDeAsedio (Casillero casillero) {
	
		super (casillero);
		
		this.montada = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;

}
	
	public void atacar()
    {
        System.out.println("Ataca a una unidad o edificio");
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

