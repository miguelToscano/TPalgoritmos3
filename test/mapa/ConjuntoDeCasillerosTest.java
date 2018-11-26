package mapa;

import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import org.junit.Assert;
import org.junit.Test;

import mapa.excepcionesMapa.casilleroEstaOcupado;
import unidades.Aldeano;

public class ConjuntoDeCasillerosTest
{
    private Mapa mapa;
    private Fila fila;

    public ConjuntoDeCasillerosTest() throws tamanioDeMapaInvalido
    {
        mapa = new Mapa(15,15);
    }

    @Test
    public void seCreaConTamanioElegido()
    {
        Fila fila = new Fila(5);
        Assert.assertEquals(5,fila.obtenerTamanio());
    }

    @Test
    public void contieneDevuelveTrueSiElElementoEstaEnLaFila() throws casilleroEstaOcupado
    {
        Aldeano aldeano = new Aldeano(4,0,mapa);
        Fila fila = mapa.obtenerFilas().get(4);
        Assert.assertTrue(fila.contiene(aldeano));
    }

    @Test
    public void primerColumnaReferenciaMismosCasillerosQueMapa()
    {
        Columna columna = mapa.obtenerColumnas().get(0);
        for(int i=0;i<columna.obtenerTamanio();i++)
        {
            Assert.assertEquals(mapa.obtenerCasillero(i,0),columna.obtenerCasillero(i));
        }

    }

    @Test
    public void elementoEnFilaYColumnaCoincideConElementoEnMapa() throws casilleroEstaOcupado
    {
        Aldeano aldeano = new Aldeano(4,0,mapa);
        Fila fila = mapa.obtenerFilas().get(4);
        Assert.assertEquals(fila.obtenerElemento(0),aldeano);
    }

}