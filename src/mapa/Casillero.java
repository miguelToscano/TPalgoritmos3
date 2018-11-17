package Mapa;

public class Casillero
{
    private int contenido;

    //Constructor con casillero vacio
    public Casillero ()
    {
        contenido = 0;
    }
    public Casillero (int numero)
    {
        contenido = numero;
    }

    public Casillero (int filaCasillero,int columnaCasillero)
    {

    }

    public int obtenerElemento()
    {
        return this.contenido;
    }

    public boolean estaLibre ()
    {
        return contenido == 0;
    }

    public void cambiarContenido(int contenido)
    {
        this.contenido = contenido;
    }
}
