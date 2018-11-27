package edificios;


import org.junit.Before;
import org.junit.Test;

import excepciones.superaLimitePoblacional;
import juego.Jugador;
import junit.framework.Assert;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class CastilloTest
{
	private Caja caja;
    private Mapa mapa;
    private Casillero celda;
    private Castillo castillo;
    private Jugador jugador;

    @Before
    public  void setUp () throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, superaLimitePoblacional
    {
    	this.jugador = new Jugador();
        this.mapa = new Mapa(15,15);
        this.celda = mapa.obtenerCasillero(0, 0);
        this.caja = mapa.asignarCajaACasillero(celda);
        this.castillo = new Castillo(this.caja,this.mapa,this.jugador);
    }

    @Test
    public void castilloSeCreaConCajaPasadaPorParametro() throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada
    {
        Assert.assertEquals(caja,castillo.obtenerEspacioOcupado());
    }


    @Test(expected = casilleroEstaOcupado.class)
    public void crearArmaDeAsedioLanzaExcepcionSiCasilleroEstaOcupado() throws casilleroEstaOcupado, superaLimitePoblacional
    {
        castillo.crearArmaDeAsedio();
        castillo.crearArmaDeAsedio(); //como el arma de asedio no se movio la
                                        // crea en el mismo lugar(puntoRally)
    }

    @Test
    public void tieneArmaDeAsedio() throws casilleroEstaOcupado,superaLimitePoblacional
    {
        castillo.crearArmaDeAsedio();
        Assert.assertTrue(castillo.tieneArmaDeAsedio());
    }

    @Test
    public void atacarCircundantes()
    {
    }

    @Test
    public void ubicar() {
    }
}