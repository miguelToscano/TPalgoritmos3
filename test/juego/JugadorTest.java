package juego;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edificios.PlazaCentral;
import excepciones.superaLimitePoblacional;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class JugadorTest {

    private Mapa mapa;
    private Jugador jugador;

    @Before
    public void setUp() throws tamanioDeMapaInvalido
    {
        mapa = new Mapa(15,15);
        jugador = new Jugador();
    }

    @Test
    public void asignarCastillo() {
    }

    @Test
    public void getCastillo() {
    }

    @Test
    public void agregarPlazaCentral() throws casilleroInvalido, cajaEstaOcupada, superaLimitePoblacional
    {
        Casillero casillero = mapa.obtenerCasillero(0,0);
        Caja caja = mapa.asignarCajaACasillero(casillero);
        PlazaCentral plaza =  new PlazaCentral(caja, mapa,this.jugador);
        this.jugador.agregarPlazaCentral(plaza);
        Assert.assertEquals(this.jugador.getPlazas().get(0),plaza);
    }

    @Test
    public void obtenerPoblacion() {
    }

    @Test
    public void establecerPoblacion() {
    }

    @Test
    public void aumentarPoblacion() {
    }

    @Test
    public void jugadorSeCreaConOroInicial() {

        Jugador jugador = new Jugador();
        Assert.assertEquals(100, jugador.obtenerOro());
    }
}