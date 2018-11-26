package juego;

import org.junit.Assert;
import org.junit.Test;
import mapa.Mapa;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

import static org.junit.Assert.*;

public class JuegoTest
{
    private Jugador jugadorA;
    private Jugador jugadorB;
    private Mapa mapa;
    private Juego juego;

    public JuegoTest() throws tamanioDeMapaInvalido
    {
        jugadorA = new Jugador();
        jugadorB = new Jugador();
        Juego juego = new Juego(jugadorA,jugadorB);
        mapa = juego.getMapa();

    }
//ARREGLARR!!!!!
    @Test
    public void juegoSeCreaConCastilloDeJugadorAEnEsquinaNoroeste() throws tamanioDeMapaInvalido
    {

        for (int i=0;i<4;i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Assert.assertEquals(this.mapa.obtenerElemento(i,j),this.jugadorA.getCastillo());
            }
        }
    }

    @Test
    public void juegoSeCreaConCastilloDeJugadorBEnEsquinaSureste()
    {
        for (int i=mapa.obtenerTamanioColumnas()-4;i<mapa.obtenerTamanioColumnas();i++)
        {
            for (int j = mapa.obtenerTamanioFilas()-4; j < mapa.obtenerTamanioFilas(); j++)
            {
                Assert.assertEquals(mapa.obtenerElemento(i,j),this.jugadorB.getCastillo());
            }
        }
    }

}