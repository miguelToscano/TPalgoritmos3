package unidades;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import edificios.Cuartel;
import edificios.PlazaCentral;
import excepciones.superaLimitePoblacional;
import juego.Jugador;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class EspadachinTest {

	private Mapa mapa;
	private int filaDet;
	private int columnaDet;
	private Casillero celda;
	private Jugador jugador;
	Casillero casilleroMock = Mockito.mock(Casillero.class);
	Caja cajaMock = Mockito.mock(Caja.class);
	Mapa mapaMock = Mockito.mock(Mapa.class);
	Jugador jugadorMock = Mockito.mock(Jugador.class);
	PlazaCentral plazaMock = Mockito.mock(PlazaCentral.class);

	@Before
    public void setUp()  throws tamanioDeMapaInvalido {
		mapa = new Mapa(15, 15);
		filaDet = 3;
		columnaDet = 3;
		jugador = new Jugador();
	}

	@Test
	public void seCreoEspadachinConCoordenadas() throws casilleroEstaOcupado,superaLimitePoblacional {

		Espadachin unEspadachin = new Espadachin(filaDet, columnaDet, mapa, jugador);
		Assert.assertEquals(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seCreoEspadachinConCasillero() throws casilleroEstaOcupado,superaLimitePoblacional {

		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Espadachin unEspadachin = new Espadachin(celda, jugador);
		Assert.assertEquals(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente1() throws casilleroEstaOcupado,superaLimitePoblacional {

		// y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet);
		Espadachin unEspadachin = new Espadachin(filaDet, columnaDet, mapa, jugador);
		unEspadachin.mover(celda);

		Assert.assertEquals(unEspadachin, mapa.obtenerElemento(filaDet + 1, columnaDet));
		Assert.assertNotSame(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente2() throws casilleroEstaOcupado,superaLimitePoblacional {

		// y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet);
		Espadachin unEspadachin = new Espadachin(filaDet, columnaDet, mapa, jugador);
		unEspadachin.mover(celda);

		Assert.assertEquals(unEspadachin, mapa.obtenerElemento(filaDet - 1, columnaDet));
		Assert.assertNotSame(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente3() throws casilleroEstaOcupado,superaLimitePoblacional {

		// x+1
		celda = mapa.obtenerCasillero(filaDet, columnaDet + 1);
		Espadachin unEspadachin = new Espadachin(filaDet, columnaDet, mapa, jugador);
		unEspadachin.mover(celda);

		Assert.assertEquals(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet + 1));
		Assert.assertNotSame(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente4() throws casilleroEstaOcupado,superaLimitePoblacional {

		// x-1
		celda = mapa.obtenerCasillero(filaDet, columnaDet - 1);
		Espadachin unEspadachin = new Espadachin(filaDet, columnaDet, mapa, jugador);
		unEspadachin.mover(celda);

		Assert.assertEquals(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet - 1));
		Assert.assertNotSame(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente5() throws casilleroEstaOcupado,superaLimitePoblacional {

		// x-1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet - 1);
		Espadachin unEspadachin = new Espadachin(filaDet, columnaDet, mapa, jugador);
		unEspadachin.mover(celda);

		Assert.assertEquals(unEspadachin, mapa.obtenerElemento(filaDet - 1, columnaDet - 1));
		Assert.assertNotSame(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente6() throws casilleroEstaOcupado,superaLimitePoblacional {

		// x+1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet + 1);
		Espadachin unEspadachin = new Espadachin(filaDet, columnaDet, mapa, jugador);
		unEspadachin.mover(celda);

		Assert.assertEquals(unEspadachin, mapa.obtenerElemento(filaDet + 1, columnaDet + 1));
		Assert.assertNotSame(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente7() throws casilleroEstaOcupado,superaLimitePoblacional {

		// x+1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet + 1);
		Espadachin unEspadachin = new Espadachin(filaDet, columnaDet, mapa, jugador);
		unEspadachin.mover(celda);

		Assert.assertEquals(unEspadachin, mapa.obtenerElemento(filaDet - 1, columnaDet + 1));
		Assert.assertNotSame(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente8() throws casilleroEstaOcupado,superaLimitePoblacional {

		// x-1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet - 1);
		Espadachin unEspadachin = new Espadachin(filaDet, columnaDet, mapa, jugador);
		unEspadachin.mover(celda);

		Assert.assertEquals(unEspadachin, mapa.obtenerElemento(filaDet + 1, columnaDet - 1));
		Assert.assertNotSame(unEspadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test(expected = casilleroEstaOcupado.class)

	public void seCreaEnLugarOcupadoPorUnidadLanzaExcepcion() throws casilleroEstaOcupado,superaLimitePoblacional {
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Espadachin unEspadachin = new Espadachin(celda, jugador);
		Espadachin unEspadachinBis = new Espadachin(celda, jugador);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seMueveAUnLugarOcupadoPorUnidadLanzaExcepcion() throws casilleroEstaOcupado,superaLimitePoblacional {
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet + 1);
		Casillero celdaBis = mapa.obtenerCasillero(filaDet, columnaDet);

		Espadachin unEspadachin = new Espadachin(celda, jugador);
		Espadachin unEspadachinBis = new Espadachin(celdaBis, jugador);

		unEspadachinBis.mover(celda);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seCreaEnUnLugarOcupadoPorEdificioLanzaExcepcion()
			throws casilleroEstaOcupado, casilleroInvalido, cajaEstaOcupada, superaLimitePoblacional {
		// creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel(caja, this.mapa, this.jugador);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Espadachin unEspadachin = new Espadachin(mapa.obtenerCasillero(6, 7), jugador);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seMueveAUnLugarOcupadoPorEdificioLanzaExcepcion()
			throws casilleroEstaOcupado, casilleroInvalido, cajaEstaOcupada, superaLimitePoblacional {
		// creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel(caja, this.mapa, jugador);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Espadachin unEspadachin = new Espadachin(mapa.obtenerCasillero(5, 5), jugador);
		unEspadachin.mover(celda);

	}
}