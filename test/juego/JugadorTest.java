package juego;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import mapa.*;
import edificios.*;
import unidades.*;
import juego.*;
import mapa.excepcionesMapa.*;

public class JugadorTest {

    private Mapa mapa;
    private Jugador jugador;

    public JugadorTest() throws tamanioDeMapaInvalido
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
    public void agregarPlazaCentral() throws casilleroInvalido, cajaEstaOcupada
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
}