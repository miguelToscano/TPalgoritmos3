package mapa;

import org.junit.Assert;
import org.junit.Test;

import excepciones.CasilleroLleno;
import unidades.Aldeano;

import static org.junit.Assert.*;

public class ConjuntoDeCasillerosTest
{

    @Test
    public void seCreaConTamanioElegido()
    {
        Fila fila = new Fila(5);
        Assert.assertEquals(5,fila.obtenerTamanio());
    }

    @Test
    public void contieneDevuelveTrueSiElElementoEstaEnLaFila() throws CasilleroLleno
    {
        Mapa mapa = new Mapa();
        Aldeano aldeano = new Aldeano(4,0,mapa);
        Fila fila = mapa.obtenerFilas().get(4);
        Assert.assertTrue(fila.contiene(aldeano));
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
    public void elementoEnFilaYColumnaCoincideConElementoEnMapa() throws CasilleroLleno
    {
        Mapa mapa = new Mapa();
        Aldeano aldeano = new Aldeano(4,0,mapa);
        Fila fila = mapa.obtenerFilas().get(4);
        Assert.assertEquals(fila.obtenerElemento(0),aldeano);
    }

}