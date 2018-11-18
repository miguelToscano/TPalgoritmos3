package mapa;

import org.junit.Assert;
import org.junit.Test;

import unidades.Aldeano;

import static org.junit.Assert.*;

public class FilaTest
{
    @Test
    public void estaLibreDevuelveTrueParaCuartaFilaDeMapaVacio()
    {
        Mapa mapa = new Mapa();
        Fila fila = mapa.obtenerFilas().get(3);
        Assert.assertTrue(fila.estaLibre());
    }

    @Test
    public void estaLibreDevuelveFalseParaFilaOcupadaDelMapa()
    {
        Mapa mapa = new Mapa();
        Aldeano aldeano = new Aldeano();
        mapa.cambiarContenidoDeCasillero(0,1,aldeano);
        Fila fila = mapa.obtenerFilas().get(0);
        Assert.assertFalse(fila.estaLibre());

    }
}