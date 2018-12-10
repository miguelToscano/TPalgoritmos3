package mapa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.SuperaLimitePoblacional;
import juego.Jugador;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import unidades.Aldeano;

public class ConjuntoDeCasillerosTest
{
    private Mapa mapa;
    private Fila fila;
    private Jugador jugador;

    @Before
    public void setUp()  throws tamanioDeMapaInvalido
    {
        mapa = new Mapa(15,15);
        jugador = new Jugador();
    }

    @Test
    public void seCreaConTamanioElegido()
    {
        Fila fila = new Fila(5);
        Assert.assertEquals(5,fila.obtenerTamanio());
    }

    @Test
    public void contieneDevuelveTrueSiElElementoEstaEnLaFila() throws casilleroEstaOcupado , SuperaLimitePoblacional
    {
        Aldeano aldeano = new Aldeano(4,0,mapa, jugador);
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
    public void elementoEnFilaYColumnaCoincideConElementoEnMapa() throws casilleroEstaOcupado, SuperaLimitePoblacional
    {
        Aldeano aldeano = new Aldeano(4,0,mapa, jugador);
        Fila fila = mapa.obtenerFilas().get(4);
        Assert.assertEquals(fila.obtenerElemento(0),aldeano);
    }

}