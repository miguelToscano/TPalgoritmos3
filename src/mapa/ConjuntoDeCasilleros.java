package mapa;

import java.util.ArrayList;
import unidades.Entidad;

public abstract class ConjuntoDeCasilleros extends Mapeable
{
    protected ArrayList<Casillero> lista = new ArrayList<Casillero>();
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

    public Casillero obtenerPrimerCasillero()
    {
        return this.lista.get(0);
    }

    public boolean contiene(Casillero casillero)
    {
        boolean contiene = false;

        for(int i=0;i<this.tamanio;i++)
        {
            if(this.obtenerCasillero(i)==casillero)
            {
                contiene = true;
            }
        }

        return contiene;
    }
    
    public ArrayList<Casillero>  getLista() {
    	return lista;
    	
    }
}