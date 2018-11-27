package juego;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.superaLimitePoblacional;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class JuegoTest {
    private Jugador jugadorA;
    private Jugador jugadorB;
    private Mapa mapa;
    private Juego juego;
    
    @Before
    public void setUp() throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada,superaLimitePoblacional
    {
        jugadorA = new Jugador();
        jugadorB = new Jugador();
        this.juego = new Juego(jugadorA, jugadorB);
        this.mapa = juego.getMapa();

    }

    @Test
    public void juegoSeCreaConCastilloDeJugadorAEnEsquinaNoroeste()
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Assert.assertEquals(this.mapa.obtenerElemento(i, j), this.jugadorA.getCastillo());
            }
        }
    }

    @Test
    public void juegoSeCreaConCastilloDeJugadorBEnEsquinaSureste()
    {
        for (int i = mapa.obtenerTamanioColumnas() - 4; i < mapa.obtenerTamanioColumnas(); i++) {
            for (int j = mapa.obtenerTamanioFilas() - 4; j < mapa.obtenerTamanioFilas(); j++) {
                Assert.assertEquals(mapa.obtenerElemento(i, j), this.jugadorB.getCastillo());
            }
        }
    }

    @Test
    public void juegoSeCreaConPlazaDeJugadorAEnEsquinaSudoeste()
    {
        for(int i=mapa.obtenerTamanioFilas()-2;i<mapa.obtenerTamanioFilas();i++)
        {
            for(int j=0;j<2;j++)
                Assert.assertEquals(mapa.obtenerElemento(i,j),this.jugadorA.getPlazas().get(0));
        }
    }

    @Test
    public void juegoSeCreaConPlazaDeJugadorBEnEsquinaNoreste()
    {
        for(int i=0;i<2;i++)
        {
            for(int j=mapa.obtenerTamanioColumnas()-2;j<mapa.obtenerTamanioColumnas();j++)
                Assert.assertEquals(mapa.obtenerElemento(i,j),this.jugadorB.getPlazas().get(0));
        }
    }

}