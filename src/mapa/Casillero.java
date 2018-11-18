package mapa;

import unidades.Entidad;

public class Casillero
{
    private Entidad contenido;
    private boolean estaLibre;

    //Constructor con casillero vacio
    public Casillero ()
    {
        this.estaLibre=true;

    }
    public Casillero (Entidad entidad)
    {
        contenido = entidad;
    }


    public Entidad obtenerElemento()
    {
        return this.contenido;
    }

    public boolean estaLibre ()
    {
        return this.estaLibre;
    }

    public void cambiarContenido(Entidad contenido)
    {
        this.contenido = contenido;
    }
}
