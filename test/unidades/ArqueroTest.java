package unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edificios.Cuartel;
import edificios.PlazaCentral;
import excepciones.MovimientoInvalido;
import excepciones.NoEsElTurnoDelJugador;
import excepciones.PiezaDeshabilitadaEnTurno;
import excepciones.superaLimitePoblacional;
import juego.Jugador;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class ArqueroTest {

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
		jugador.habilitar();
	}

	@Test
	public void seCreoArqueroConCoordenadas() throws casilleroEstaOcupado,superaLimitePoblacional {

		Arquero unArquero = new Arquero(filaDet, columnaDet, mapa, jugador);
		Assert.assertEquals(unArquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seCreoArqueroConCasillero() throws casilleroEstaOcupado,superaLimitePoblacional {

		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Arquero unArquero = new Arquero(celda, jugador);
		Assert.assertEquals(unArquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente1() throws NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,MovimientoInvalido,casilleroEstaOcupado,superaLimitePoblacional {

		// y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet);
		Arquero unArquero = new Arquero(filaDet, columnaDet, mapa, jugador);
		unArquero.mover(celda);

		Assert.assertEquals(unArquero, mapa.obtenerElemento(filaDet + 1, columnaDet));
		Assert.assertNotSame(unArquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente2() throws NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,MovimientoInvalido,casilleroEstaOcupado,superaLimitePoblacional {

		// y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet);
		Arquero unArquero = new Arquero(filaDet, columnaDet, mapa, jugador);
		unArquero.mover(celda);

		Assert.assertEquals(unArquero, mapa.obtenerElemento(filaDet - 1, columnaDet));
		Assert.assertNotSame(unArquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente3() throws NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,MovimientoInvalido,casilleroEstaOcupado,superaLimitePoblacional {

		// x+1
		celda = mapa.obtenerCasillero(filaDet, columnaDet + 1);
		Arquero unArquero = new Arquero(filaDet, columnaDet, mapa, jugador);
		unArquero.mover(celda);

		Assert.assertEquals(unArquero, mapa.obtenerElemento(filaDet, columnaDet + 1));
		Assert.assertNotSame(unArquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente4() throws NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,MovimientoInvalido,casilleroEstaOcupado,superaLimitePoblacional {

		// x-1
		celda = mapa.obtenerCasillero(filaDet, columnaDet - 1);
		Arquero unArquero = new Arquero(filaDet, columnaDet, mapa, jugador);
		unArquero.mover(celda);

		Assert.assertEquals(unArquero, mapa.obtenerElemento(filaDet, columnaDet - 1));
		Assert.assertNotSame(unArquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente5() throws NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,MovimientoInvalido,casilleroEstaOcupado,superaLimitePoblacional {

		// x-1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet - 1);
		Arquero unArquero = new Arquero(filaDet, columnaDet, mapa, jugador);
		unArquero.mover(celda);

		Assert.assertEquals(unArquero, mapa.obtenerElemento(filaDet - 1, columnaDet - 1));
		Assert.assertNotSame(unArquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente6() throws NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,MovimientoInvalido,casilleroEstaOcupado,superaLimitePoblacional {

		// x+1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet + 1);
		Arquero unArquero = new Arquero(filaDet, columnaDet, mapa, jugador);
		unArquero.mover(celda);

		Assert.assertEquals(unArquero, mapa.obtenerElemento(filaDet + 1, columnaDet + 1));
		Assert.assertNotSame(unArquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente7() throws NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,MovimientoInvalido,casilleroEstaOcupado,superaLimitePoblacional {

		// x+1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet + 1);
		Arquero unArquero = new Arquero(filaDet, columnaDet, mapa, jugador);
		unArquero.mover(celda);

		Assert.assertEquals(unArquero, mapa.obtenerElemento(filaDet - 1, columnaDet + 1));
		Assert.assertNotSame(unArquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente8() throws NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,MovimientoInvalido,casilleroEstaOcupado,superaLimitePoblacional {

		// x-1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet - 1);
		Arquero unArquero = new Arquero(filaDet, columnaDet, mapa, jugador);
		unArquero.mover(celda);

		Assert.assertEquals(unArquero, mapa.obtenerElemento(filaDet + 1, columnaDet - 1));
		Assert.assertNotSame(unArquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test(expected = casilleroEstaOcupado.class)

	public void seCreaEnLugarOcupadoPorUnidadLanzaExcepcion() throws casilleroEstaOcupado,superaLimitePoblacional {
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Arquero unArquero = new Arquero(celda, jugador);
		Arquero unArqueroBis = new Arquero(celda, jugador);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seMueveAUnLugarOcupadoPorUnidadLanzaExcepcion() throws NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,MovimientoInvalido,casilleroEstaOcupado,superaLimitePoblacional {
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet + 1);
		Casillero celdaBis = mapa.obtenerCasillero(filaDet, columnaDet);

		Arquero unArquero = new Arquero(celda, jugador);
		Arquero unArqueroBis = new Arquero(celdaBis, jugador);

		unArqueroBis.mover(celda);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seCreaEnUnLugarOcupadoPorEdificioLanzaExcepcion()
			throws casilleroEstaOcupado, casilleroInvalido, cajaEstaOcupada, superaLimitePoblacional {
		// creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel(caja, this.mapa, this.jugador);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Arquero unArquero = new Arquero(mapa.obtenerCasillero(6, 7), jugador);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seMueveAUnLugarOcupadoPorEdificioLanzaExcepcion()
			throws NoEsElTurnoDelJugador,PiezaDeshabilitadaEnTurno,casilleroEstaOcupado, casilleroInvalido, MovimientoInvalido,cajaEstaOcupada, superaLimitePoblacional {
		// creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel(caja, this.mapa, jugador);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Arquero unArquero = new Arquero(mapa.obtenerCasillero(5, 5), jugador);
		unArquero.mover(celda);

	}
}
