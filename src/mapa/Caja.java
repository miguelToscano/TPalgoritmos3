package mapa;
import edificios.*;

public class Caja extends ConjuntoDeCasilleros
{

    public Caja(int tamanio)
    {
        this.tamanio = tamanio;
    }

    public void llenar (Edificio edificio)
    {
    	for (Casillero celda : lista) {
    		celda.cambiarContenido(edificio);
    	}
    }
    
}
