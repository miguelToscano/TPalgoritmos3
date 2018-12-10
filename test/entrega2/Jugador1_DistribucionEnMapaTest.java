package entrega2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edificios.Castillo;
import excepciones.SuperaLimitePoblacional;
import juego.Juego;
import juego.Jugador;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class Jugador1_DistribucionEnMapaTest {
	 private Jugador jugadorA;
	    private Jugador jugadorB;
	    private Mapa mapa;
	    private Juego juego;

	    @Before
	    public void setUp() throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, casilleroEstaOcupado {
	        this.jugadorA = new Jugador();
	        this.jugadorB = new Jugador();
	        this.juego = new Juego(this.jugadorA, this.jugadorB);
	        this.mapa = juego.getMapa();

	    }

	    @Test
	    public void juegoSeCreaConCastilloDeJugadorAEnEsquinaNoroeste() {

	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                Assert.assertTrue(this.mapa.obtenerElemento(i, j) instanceof Castillo);
	                Assert.assertTrue(this.mapa.obtenerElemento(i, j).getJugador() == this.jugadorA);
	            }
	        }
	    }

	    @Test
	    public void juegoSeCreaConCastilloDeJugadorBEnEsquinaSureste() {
	        for (int i = mapa.obtenerTamanioColumnas() - 4; i < mapa.obtenerTamanioColumnas(); i++) {
	            for (int j = mapa.obtenerTamanioFilas() - 4; j < mapa.obtenerTamanioFilas(); j++) {
	                Assert.assertTrue(this.mapa.obtenerElemento(i, j) instanceof Castillo);
	                Assert.assertTrue(this.mapa.obtenerElemento(i, j).getJugador() == this.jugadorB);
	            }
	        }
	    }

	    @Test
	    public void juegoSeCreaConPlazaDeJugadorAEnEsquinaSudoeste() {
	        for (int i = mapa.obtenerTamanioFilas() - 2; i < mapa.obtenerTamanioFilas(); i++) {
	            for (int j = 0; j < 2; j++)
	                Assert.assertEquals(mapa.obtenerElemento(i, j), this.jugadorA.getPlazas().get(0));
	        }
	    }

	    @Test
	    public void juegoSeCreaConPlazaDeJugadorBEnEsquinaNoreste() {
	        for (int i = 0; i < 2; i++) {
	            for (int j = mapa.obtenerTamanioColumnas() - 2; j < mapa.obtenerTamanioColumnas(); j++)
	                Assert.assertEquals(mapa.obtenerElemento(i, j), this.jugadorB.getPlazas().get(0));
	        }
	    }


}
