package mapa;

import org.junit.Assert;
import org.junit.Test;

import unidades.Aldeano;

public class CasilleroTest
{

    @Test
    public void casilleroSeCreaVacio()
    {
        Casillero casilleroVacio = new Casillero();
        Assert.assertTrue(casilleroVacio.estaLibre());
    }

    @Test
    public void casilleroSeCreaConContenido()
    {
        Aldeano aldeano = new Aldeano();
        Casillero casilleroLleno = new Casillero(aldeano);
        Assert.assertEquals(aldeano, casilleroLleno.obtenerElemento());
    }

    @Test
    public void seCambiaContenido()
    {
        Aldeano unAldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();
        Casillero casillero = new Casillero(unAldeano);
        casillero.cambiarContenido(otroAldeano);
        Assert.assertEquals(otroAldeano,casillero.obtenerElemento());
    }

}