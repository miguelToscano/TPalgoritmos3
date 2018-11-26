package mapa;

import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import excepciones.superaLimitePoblacional;
import org.junit.Assert;
import org.junit.Test;
import juego.*;

import mapa.excepcionesMapa.casilleroEstaOcupado;
import unidades.Aldeano;

public class FilaTest
{
    private Mapa mapa;
    private Jugador jugador ; 

    public FilaTest() throws tamanioDeMapaInvalido
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
    public void estaLibreDevuelveFalseParaFilaOcupadaDelMapa() throws casilleroEstaOcupado, superaLimitePoblacional
    {
        Aldeano aldeano = new Aldeano(0,1,mapa, jugador);
        Fila fila = mapa.obtenerFilas().get(0);
        Assert.assertFalse(fila.estaLibre());

    }
}