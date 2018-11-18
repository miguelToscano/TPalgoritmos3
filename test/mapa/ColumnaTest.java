package mapa;

import org.junit.Assert;
import org.junit.Test;

import unidades.Aldeano;

import static org.junit.Assert.*;

public class ColumnaTest
{
    @Test
    public void estaLibreDevuelveTrueParaSegundaColumnaDeMapaVacio()
    {
        Mapa mapa = new Mapa();
        Columna columna = mapa.obtenerColumnas().get(1);
        Assert.assertTrue(columna.estaLibre());
    }

    @Test
    public void estaLibreDevuelveFalseParaColumnaOcupadaDelMapa()
    {
        Mapa mapa = new Mapa();
        Aldeano aldeano = new Aldeano(0,1,mapa);
        Columna columna = mapa.obtenerColumnas().get(1);
        Assert.assertFalse(columna.estaLibre());

    }
}