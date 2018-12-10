package entrega1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edificios.Cuartel;
import edificios.PlazaCentral;
import excepciones.SuperaLimitePoblacional;
import juego.Jugador;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import unidades.Aldeano;
import unidades.Espadachin;

public class Mapa2_ColocarUnidadesyEdificiosTest {
	  
	private Mapa mapa;
	private Jugador jugador;

	@Before
	public void setUp()  throws tamanioDeMapaInvalido {
	        mapa = new Mapa(15, 15);
	        jugador = new Jugador();
	 }
	
	 @Test
	    public void seColocaAldeanoEnPrimerCasillero() throws casilleroEstaOcupado, SuperaLimitePoblacional {
	        Aldeano aldeano = new Aldeano(0, 0, mapa, jugador);
	        Assert.assertEquals(aldeano, mapa.obtenerElemento(0, 0));
	    }

	    @Test(expected = casilleroEstaOcupado.class)
	    public void colocarAldeanoEnCasilleroOcupadoLanzaExcepcion() throws casilleroEstaOcupado, SuperaLimitePoblacional {
	        Aldeano unAldeano = new Aldeano(5, 5, mapa, jugador);
	        Aldeano otroAldeano = new Aldeano(5, 5, mapa, jugador);
	    }

	    @Test
	    public void seColocaEspadachinEnCasillero() throws casilleroEstaOcupado, SuperaLimitePoblacional {
	        Casillero casillero = mapa.obtenerCasillero(3, 3);
	        Espadachin espadachin = new Espadachin(casillero , jugador);
	        Assert.assertEquals(espadachin, mapa.obtenerElemento(3, 3));
	    }

	    @Test(expected = casilleroEstaOcupado.class)
	    public void colocarEspadachinEnCasilleroOcupadoLanzaExcepcion() throws casilleroEstaOcupado, SuperaLimitePoblacional {
	        Casillero casillero = mapa.obtenerCasillero(4, 3);
	        Espadachin unEspadachin = new Espadachin(casillero,jugador);
	        Espadachin otroEspadachin = new Espadachin(casillero, jugador);
	    }

	    @Test
	    public void seColocaPlazaCentralEnCajaDadaPorCasillero() throws cajaEstaOcupada, casilleroInvalido, SuperaLimitePoblacional
	    {
	        Casillero casillero = mapa.obtenerCasillero(0, 0);
	        Caja caja = mapa.obtenerCajas().get(0);
	        PlazaCentral plaza = new PlazaCentral(casillero, mapa, this.jugador);
	        for (int i = 0; i < mapa.obtenerTamanioCajas(); i++) {
	            Assert.assertEquals(caja.obtenerElemento(i), plaza);
	        }

	    }

	    @Test(expected = cajaEstaOcupada.class)
	    public void colocarCuartelEnCajaOcupadaLanzaExcepcion() throws casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional
	    {
	        Casillero casillero = mapa.obtenerCasillero(5, 5);
	        Cuartel unCuartel = new Cuartel(casillero, mapa, this.jugador);
	        Cuartel otroCuartel = new Cuartel(casillero, mapa, this.jugador);
	    }
}
