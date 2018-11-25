package edificios;


import junit.framework.Assert;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;

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

    public CastilloTest () throws tamanioDeMapaInvalido, casilleroInvalido
    {

    	fila = 4; columna = 6;
        this.mapa = new Mapa(15,15);
        this.celda = mapa.obtenerCasillero(fila, columna);
        this.caja = mapa.asignarCajaACasillero(celda);
        

    }

    @Test
    public void castilloSeCreaConCajaPasadaPorParametro()
    {
        Castillo castillo = new Castillo(caja,this.mapa);
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