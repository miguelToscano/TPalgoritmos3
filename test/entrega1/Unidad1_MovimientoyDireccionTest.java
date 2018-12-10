package entrega1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edificios.Cuartel;
import excepciones.MovimientoInvalido;
import excepciones.NoEsElTurnoDelJugador;
import excepciones.PiezaDeshabilitadaEnTurno;
import excepciones.SuperaLimitePoblacional;
import juego.Jugador;
import mapa.*;
import mapa.excepcionesMapa.*;
import unidades.*;

public class Unidad1_MovimientoyDireccionTest {
	
	private Mapa mapa;
	private int filaDet;
	private int columnaDet;
	private Casillero celda;
	private Jugador jugador;

	@Before
	public void setUp()  throws tamanioDeMapaInvalido {
		mapa = new Mapa(15, 15);
		filaDet = 3;
		columnaDet = 3;
		jugador = new Jugador();
		jugador.habilitar();
	}

	
	@Test
	public void seCreoAldeanoConCoordenadas() throws casilleroEstaOcupado, SuperaLimitePoblacional {

		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seCreoEspadachinConCasillero() throws casilleroEstaOcupado, SuperaLimitePoblacional {

		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Espadachin espadachin = new Espadachin(celda, jugador);
		Assert.assertEquals(espadachin, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente1() throws MovimientoInvalido,casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet + 1, columnaDet));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente2() throws MovimientoInvalido,casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet - 1, columnaDet));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente3() throws MovimientoInvalido,casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x+1
		celda = mapa.obtenerCasillero(filaDet, columnaDet + 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet + 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente4() throws MovimientoInvalido,casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x-1
		celda = mapa.obtenerCasillero(filaDet, columnaDet - 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet - 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente5() throws MovimientoInvalido,casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x-1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet - 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet - 1, columnaDet - 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente6() throws MovimientoInvalido,casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x+1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet + 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet + 1, columnaDet + 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente7() throws MovimientoInvalido,casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x+1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet + 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet - 1, columnaDet + 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente8() throws MovimientoInvalido,casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x-1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet - 1);
		Arquero arquero = new Arquero(filaDet, columnaDet, mapa, jugador);
		arquero.mover(celda);

		Assert.assertEquals(arquero, mapa.obtenerElemento(filaDet + 1, columnaDet - 1));
		Assert.assertNotSame(arquero, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test(expected = casilleroEstaOcupado.class)

	public void seCreaEnLugarOcupadoPorUnidadLanzaExcepcion() throws casilleroEstaOcupado, SuperaLimitePoblacional {
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Aldeano aldeano = new Aldeano(celda, jugador);
		ArmaDeAsedio arma = new ArmaDeAsedio(celda, jugador);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seMueveAUnLugarOcupadoPorUnidadLanzaExcepcion() throws MovimientoInvalido,casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet + 1);
		Casillero celdaBis = mapa.obtenerCasillero(filaDet, columnaDet);

		Aldeano aldeano = new Aldeano(celda, jugador);
		Aldeano aldeanoBis = new Aldeano(celdaBis, jugador);

		aldeanoBis.mover(celda);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seCreaEnUnLugarOcupadoPorEdificioLanzaExcepcion()
			throws casilleroEstaOcupado, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional {
		// creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel(caja, this.mapa, this.jugador);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Aldeano aldeano = new Aldeano(mapa.obtenerCasillero(6, 7), jugador);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seMueveAUnLugarOcupadoPorEdificioLanzaExcepcion()
			throws MovimientoInvalido,casilleroEstaOcupado, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {
		// creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel(caja, this.mapa, jugador);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Aldeano aldeano = new Aldeano(mapa.obtenerCasillero(5, 5), jugador);
		aldeano.mover(celda);

	}

}
