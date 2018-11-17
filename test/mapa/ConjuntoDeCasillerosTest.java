package mapa;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConjuntoDeCasillerosTest {

    @Test
    public void seCreaConTamanioElegido()
    {
        Fila fila = new Fila(5);
        Assert.assertEquals(5,fila.obtenerTamanio());
    }

    @Test
    public void contieneDevuelveTrueSiElElementoEstaEnLaFila()
    {
        Mapa mapa = new Mapa();
        mapa.cambiarContenidoDeCasillero(4,0,3);
        Fila fila = mapa.obtenerFilas().get(4);
        Assert.assertTrue(fila.contiene(3));
    }

    @Test
    public void primerColumnaReferenciaMismosCasillerosQueMapa()
    {
        Mapa mapa = new Mapa();
        Columna columna = mapa.obtenerColumnas().get(0);
        for(int i=0;i<columna.obtenerTamanio();i++)
        {
            Assert.assertEquals(mapa.obtenerCasillero(i,0),columna.obtenerCasillero(i));
        }

    }

    @Test
    public void elementoEnFilaYColumnaCoincideConElementoEnMapa()
    {
        Mapa mapa = new Mapa();
        mapa.cambiarContenidoDeCasillero(4,0,3);
        Fila fila = mapa.obtenerFilas().get(4);
        Assert.assertEquals(fila.obtenerElemento(0),3);
    }
}