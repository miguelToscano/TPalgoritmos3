package mapa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CasilleroTest
{

    @Test
    public void casilleroSeCreaVacio() {
        Casillero casilleroVacio = new Casillero();
        Assert.assertTrue(casilleroVacio.estaLibre());
    }

    @Test
    public void casilleroSeCreaConContenido() {
        Casillero casilleroLleno = new Casillero(5);
        Assert.assertEquals(5, casilleroLleno.obtenerElemento());
    }

    @Test
    public void seCambiaContenido()
    {
        Casillero casillero = new Casillero(4);
        casillero.cambiarContenido(6);
        Assert.assertEquals(6,casillero.obtenerElemento());
    }

}