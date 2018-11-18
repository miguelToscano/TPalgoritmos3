package edificios;

import junit.framework.Assert;
import mapa.Caja;
import mapa.Mapa;

import org.junit.Test;


import static org.junit.Assert.*;

public class CastilloTest {

    private Caja caja;
    private Mapa mapa;


    public CastilloTest ()
    {
        mapa = new Mapa();
        caja = new Caja(16);

    }

    @Test
    public void castilloSeCreaConCajaPasadaPorParametro()
    {
        Castillo castillo = new Castillo(caja);
        Assert.assertEquals(caja,castillo.obtenerEspacioOcupado());
    }

    @Test
    public void crearArmaDeAsedioLanzaExcepcionSiCasilleroEstaOcupado()
    {

    }

    @Test
    public void tieneArmaDeAsedio() {
    }

    @Test
    public void atacarCircundantes() {
    }

    @Test
    public void ubicar() {
    }
}