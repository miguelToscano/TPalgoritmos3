package mapa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.SuperaLimitePoblacional;
import juego.Jugador;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import unidades.Aldeano;

public class FilaTest
{
    private Mapa mapa;
    private Jugador jugador ; 

    @Before
    public void setUp()  throws tamanioDeMapaInvalido
    {
        this.mapa = new Mapa(15,15);
        jugador = new Jugador();
    }
    @Test
    public void estaLibreDevuelveTrueParaCuartaFilaDeMapaVacio()
    {
        Fila fila = mapa.obtenerFilas().get(3);
        Assert.assertTrue(fila.estaLibre());
    }

    @Test
    public void estaLibreDevuelveFalseParaFilaOcupadaDelMapa() throws casilleroEstaOcupado, SuperaLimitePoblacional
    {
        Aldeano aldeano = new Aldeano(0,1,mapa, jugador);
        Fila fila = mapa.obtenerFilas().get(0);
        Assert.assertFalse(fila.estaLibre());

    }
}