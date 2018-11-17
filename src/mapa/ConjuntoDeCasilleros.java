package mapa;

import java.util.ArrayList;

public abstract class ConjuntoDeCasilleros
{
    private ArrayList<Casillero> lista = new ArrayList<Casillero>();
    protected int tamanio;


    public void referenciarCasillero(Casillero casillero)
    {
        this.lista.add(casillero);
        return;
    }



    public int obtenerTamanio()
    {
        return this.tamanio;
    }

    public boolean contiene(int numero)
    {
        return true;
    }

    public Casillero obtenerCasillero(int posicion)
    {
        return lista.get(posicion);
    }
    public int obtenerElemento(int posicion)
    {
        return this.obtenerCasillero(posicion).obtenerElemento();
    }

}
