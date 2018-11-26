package edificios;


import junit.framework.Assert;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.*;
import jugador.*;

import org.junit.Test;


import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class CastilloTest
{
	private Caja caja;
    private Mapa mapa;
    private Casillero celda;
    private PlazaCentral plaza;
    private int fila,columna;
    private Castillo castillo;
    private Jugador jugador;

    public CastilloTest () throws tamanioDeMapaInvalido, casilleroInvalido
    {
    	fila = 4;
    	columna = 6;
    	this.jugador = new Jugador();
        this.mapa = new Mapa(15,15);
        this.celda = mapa.obtenerCasillero(this.fila, this.columna);
        this.caja = mapa.asignarCajaACasillero(celda);
        this.castillo = new Castillo(this.caja,this.mapa,this.jugador);
    }

    @Test
    public void castilloSeCreaConCajaPasadaPorParametro()
    {
        Assert.assertEquals(caja,castillo.obtenerEspacioOcupado());
    }

    @Test(expected = casilleroEstaOcupado.class)
    public void crearArmaDeAsedioLanzaExcepcionSiCasilleroEstaOcupado() throws casilleroEstaOcupado
    {
        castillo.crearArmaDeAsedio();
        castillo.crearArmaDeAsedio(); //como el arma de asedio no se movio la
                                        // crea en el mismo lugar(puntoRally)
    }

    @Test
    public void tieneArmaDeAsedio() throws casilleroEstaOcupado
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