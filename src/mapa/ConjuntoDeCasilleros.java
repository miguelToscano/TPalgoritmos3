package mapa;

import java.util.ArrayList;
import unidades.Entidad;

public abstract class ConjuntoDeCasilleros extends Mapeable
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

    public boolean contiene(Entidad entidad)
    {
        boolean contiene = false;

        for(int i=0;i<this.tamanio;i++)
        {
            if (this.obtenerElemento(i) == entidad)
            {
                contiene = true;
                break;
            }
        }
        return contiene;

    }

    public Casillero obtenerCasillero(int posicion)
    {
        return lista.get(posicion);
    }
    public Entidad obtenerElemento(int posicion)
    {
        return this.obtenerCasillero(posicion).obtenerElemento();
    }

    public boolean estaLibre()
    {
        boolean estaLibre = true;
        for(int i=0;i<this.tamanio;i++)
        {
            if(this.obtenerCasillero(i).estaOcupado())
            {
                estaLibre = false;
            }
        }
        return estaLibre;
    }

}