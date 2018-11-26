package mapa;
import java.util.ArrayList;

import edificios.*;

public class Caja extends ConjuntoDeCasilleros
{

	public Caja() {
		
		super();
	}
	
    public Caja(int tamanio)
    {
    	super(tamanio);
        this.tamanio = tamanio;
    }

    public void llenar (Edificio edificio)
    {
    	for (Casillero celda : this.lista) {
    		celda.cambiarContenido(edificio);
    	}
    }
    
}
