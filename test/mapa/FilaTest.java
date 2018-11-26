package mapa;

import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import org.junit.Assert;
import org.junit.Test;
import juego.Jugador;

import mapa.excepcionesMapa.casilleroEstaOcupado;
import unidades.Aldeano;

public class FilaTest
{
    private Mapa mapa;

    public FilaTest() throws tamanioDeMapaInvalido
    {
        this.mapa = new Mapa(15,15);
    }
    @Test
    public void estaLibreDevuelveTrueParaCuartaFilaDeMapaVacio()
    {
        Fila fila = mapa.obtenerFilas().get(3);
        Assert.assertTrue(fila.estaLibre());
    }

    @Test
    public void estaLibreDevuelveFalseParaFilaOcupadaDelMapa() throws casilleroEstaOcupado
    {
        Aldeano aldeano = new Aldeano(0,1,mapa);
        Fila fila = mapa.obtenerFilas().get(0);
        Assert.assertFalse(fila.estaLibre());

    }
}