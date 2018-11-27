package mapa;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edificios.Cuartel;
import edificios.PlazaCentral;
import excepciones.superaLimitePoblacional;
import juego.Jugador;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import unidades.Aldeano;
import unidades.Espadachin;
public class MapaTest {

    private Mapa mapa;
    private Jugador jugador;

    @Before
    public void setUp()  throws tamanioDeMapaInvalido {
        mapa = new Mapa(15, 15);
        jugador = new Jugador();
    }

    @Test
    public void seCreaConTamanioPasadoPorParametros() throws tamanioDeMapaInvalido {
        try {
            Mapa mapaPrueba = new Mapa(20, 20);
        } catch (tamanioDeMapaInvalido e) {
            fail("La prueba no paso. El tamanio del mapa no es valido");
        }
        Mapa mapaPrueba = new Mapa(20, 20);
        Assert.assertEquals(400, mapaPrueba.obtenerTamanio());
    }

    @Test(expected = tamanioDeMapaInvalido.class)
    public void crearMapaConTamanioInvalidoLanzaError() throws tamanioDeMapaInvalido {
        new Mapa(1, 15);
    }

    @Test
    public void seCreaConCasillerosVacios() {
        for (int i = 0; i < mapa.obtenerTamanioFilas(); i++) {
            for (int j = 0; j < mapa.obtenerTamanioColumnas(); j++) {
                Assert.assertTrue(mapa.obtenerCasillero(i, j).estaLibre());
            }
        }
    }


    @Test
    public void seColocaAldeanoEnPrimerCasillero() throws casilleroEstaOcupado,superaLimitePoblacional {
        Aldeano aldeano = new Aldeano(0, 0, mapa, jugador);
        Assert.assertEquals(aldeano, mapa.obtenerElemento(0, 0));
    }

    @Test(expected = casilleroEstaOcupado.class)
    public void colocarAldeanoEnCasilleroOcupadoLanzaExcepcion() throws casilleroEstaOcupado,superaLimitePoblacional {
        Aldeano unAldeano = new Aldeano(5, 5, mapa, jugador);
        Aldeano otroAldeano = new Aldeano(5, 5, mapa, jugador);
    }

    @Test
    public void seColocaEspadachinEnCasillero() throws casilleroEstaOcupado,superaLimitePoblacional {
        Casillero casillero = mapa.obtenerCasillero(3, 3);
        Espadachin espadachin = new Espadachin(casillero , jugador);
        Assert.assertEquals(espadachin, mapa.obtenerElemento(3, 3));
    }

    @Test(expected = casilleroEstaOcupado.class)
    public void colocarEspadachinEnCasilleroOcupadoLanzaExcepcion() throws casilleroEstaOcupado,superaLimitePoblacional {
        Casillero casillero = mapa.obtenerCasillero(4, 3);
        Espadachin unEspadachin = new Espadachin(casillero,jugador);
        Espadachin otroEspadachin = new Espadachin(casillero, jugador);
    }

    @Test
    public void seColocaPlazaCentralEnCajaDadaPorCasillero() throws cajaEstaOcupada, casilleroInvalido,superaLimitePoblacional
    {
        Casillero casillero = mapa.obtenerCasillero(0, 0);
        Caja caja = mapa.obtenerCajas().get(0);
        PlazaCentral plaza = new PlazaCentral(casillero, mapa, this.jugador);
        for (int i = 0; i < mapa.obtenerTamanioCajas(); i++) {
            Assert.assertEquals(caja.obtenerElemento(i), plaza);
        }

    }

    @Test(expected = cajaEstaOcupada.class)
    public void colocarCuartelEnCajaOcupadaLanzaExcepcion() throws casilleroInvalido, cajaEstaOcupada,superaLimitePoblacional
    {
        Casillero casillero = mapa.obtenerCasillero(5, 5);
        Cuartel unCuartel = new Cuartel(casillero, mapa, this.jugador);
        Cuartel otroCuartel = new Cuartel(casillero, mapa, this.jugador);
    }

    @Test
    public void obtenerSegundaFilaDevuelveLaSegundaFilaDelMapa() {
        Fila segundaFila = mapa.obtenerFilas().get(1);

        for (int i = 0; i < mapa.obtenerTamanioColumnas(); i++) {
            Assert.assertEquals(mapa.obtenerCasillero(1, i), segundaFila.obtenerCasillero(i));
        }
    }

    @Test
    public void obtenerPrimerColumnaDevuelveLaPrimerColumnaDelMapa() {
        Columna primerColumna = mapa.obtenerColumnas().get(0);

        for (int i = 0; i < mapa.obtenerTamanioFilas(); i++) {
            Assert.assertEquals(mapa.obtenerCasillero(i, 0), primerColumna.obtenerCasillero(i));
        }
    }

    @Test
    public void obtenerPrimerCajaDevuelveLaPrimerCajaDelMapa() {
        Caja primerCaja = mapa.obtenerCajas().get(0);
        int k = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(mapa.obtenerCasillero(i, j), primerCaja.obtenerCasillero(k));
                k++;
            }
        }
    }

    @Test
    public void obtenerTercerCajaAPartirDeTercerCasillero() throws casilleroInvalido {

        Caja tercerCaja = mapa.obtenerCajas().get(2);
        Casillero tercerCasillero = mapa.obtenerCasillero(0, 2);
        try {
            mapa.asignarCajaACasillero(tercerCasillero);
        } catch (casilleroInvalido c) {
            fail("La prueba no paso. El casillero elegido no es valido");
        }

        Caja cajaRetornada = mapa.asignarCajaACasillero(tercerCasillero);
        Assert.assertEquals(cajaRetornada, tercerCaja);
    }

    @Test(expected = casilleroInvalido.class)
    public void obtenerCajaAPartirDeCasilleroLimiteLanzaExcepcion() throws casilleroInvalido {
        Casillero casilleroLimite = mapa.obtenerCasillero(mapa.obtenerTamanioFilas() - 1, mapa.obtenerTamanioColumnas() - 1);
        mapa.asignarCajaACasillero(casilleroLimite);
    }

    @Test
    public void obtenerFilaIntDevuelveNumeroDeFilaCorrecto()
    {
        Casillero casillero = mapa.obtenerCasillero(4,0);
        Assert.assertEquals(mapa.obtenerFilaInt(casillero),4);
    }

    @Test
    public void obtenerColumnaIntDevuelveNumeroDeColumnaCorrecto()
    {
        Casillero casillero = mapa.obtenerCasillero(8,8);
        Assert.assertEquals(mapa.obtenerColumnaInt(casillero),8);
    }


}