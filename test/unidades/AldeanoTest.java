package unidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edificios.Cuartel;
import edificios.PlazaCentral;
import excepciones.*;
import juego.Jugador;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.*;

public class AldeanoTest {

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
	public void setUp() throws tamanioDeMapaInvalido {
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
	public void seCreoAldeanoConCasillero() throws casilleroEstaOcupado, SuperaLimitePoblacional {

		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Aldeano aldeano = new Aldeano(celda, jugador);
		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente1() throws MovimientoInvalido, casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet + 1, columnaDet));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente2() throws MovimientoInvalido, casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet - 1, columnaDet));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente3() throws MovimientoInvalido, casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x+1
		celda = mapa.obtenerCasillero(filaDet, columnaDet + 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet + 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente4() throws MovimientoInvalido, casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x-1
		celda = mapa.obtenerCasillero(filaDet, columnaDet - 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet - 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente5() throws MovimientoInvalido, casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x-1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet - 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet - 1, columnaDet - 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente6() throws MovimientoInvalido, casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x+1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet + 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet + 1, columnaDet + 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente7() throws MovimientoInvalido, casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x+1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet + 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet - 1, columnaDet + 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente8() throws MovimientoInvalido, casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {

		// x-1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet - 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa, jugador);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet + 1, columnaDet - 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test(expected = casilleroEstaOcupado.class)

	public void seCreaEnLugarOcupadoPorUnidadLanzaExcepcion() throws casilleroEstaOcupado, SuperaLimitePoblacional {
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Aldeano aldeano = new Aldeano(celda, jugador);
		Aldeano aldeanoBis = new Aldeano(celda, jugador);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seMueveAUnLugarOcupadoPorUnidadLanzaExcepcion() throws MovimientoInvalido, casilleroEstaOcupado, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {
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
			throws MovimientoInvalido, casilleroEstaOcupado, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno {
		// creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel(caja, this.mapa, jugador);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Aldeano aldeano = new Aldeano(mapa.obtenerCasillero(5, 5), jugador);
		aldeano.mover(celda);

	}

	@Test
	public void aldeanoComienzaAConstruirPlaza()
			throws casilleroEstaOcupado, casilleroInvalido, SuperaLimitePoblacional, CajaNoEstaPegadaAAldeano, cajaEstaOcupada, PiezaDeshabilitadaEnTurno {

		Casillero casilleroAldeano = mapa.obtenerCasillero(3,3);
		Aldeano aldeano = new Aldeano(casilleroAldeano, this.jugador);

		Casillero casilleroPlaza = mapa.obtenerCasillero(4,3);

		aldeano.construirPlazaCentral(casilleroPlaza, this.mapa, this.jugador);

		Assert.assertFalse(aldeano.obtenerEdificioEnConstruccion() == null);
	}

	@Test
	public void aldeanoConstruyendoEstaTrabajando()
			throws cajaEstaOcupada, SuperaLimitePoblacional, casilleroEstaOcupado, casilleroInvalido, CajaNoEstaPegadaAAldeano, PiezaDeshabilitadaEnTurno {

		Casillero casilleroAldeano = mapa.obtenerCasillero(3,3);
		Aldeano aldeano = new Aldeano(casilleroAldeano, this.jugador);
		Casillero casilleroPlaza = mapa.obtenerCasillero(4,3);

		aldeano.construirPlazaCentral(casilleroPlaza, this.mapa, this.jugador);

		Assert.assertTrue(aldeano.trabajando == true);
	}

	@Test
	public void aldeanoConstruyendoNoProduceOro() throws casilleroInvalido, cajaEstaOcupada, CajaNoEstaPegadaAAldeano, PiezaDeshabilitadaEnTurno {

		Aldeano aldeanoMock = Mockito.mock(Aldeano.class);
		aldeanoMock.construirPlazaCentral(this.casilleroMock, this.mapaMock, this.jugadorMock);

		Mockito.verify(aldeanoMock, Mockito.times(0)).recolectarOro();

	}

	@Test
	public void aldeanoReparacionCompleta() throws casilleroEstaOcupado, cajaEstaOcupada, SuperaLimitePoblacional {

		Aldeano aldeano = new Aldeano(this.casilleroMock, jugador);
		Cuartel cuartel = new Cuartel(cajaMock, mapaMock, jugadorMock);

		cuartel.recibirDanio(0, 50);
		aldeano.repararEdificio(cuartel);

		Assert.assertTrue(cuartel.reparacionCompleta());
	}

	@Test
	public void aldeanoReparacionCompletaVuelveARecolectar() throws casilleroEstaOcupado, cajaEstaOcupada, SuperaLimitePoblacional {

		Aldeano aldeanoMock = Mockito.mock(Aldeano.class);
		//Aldeano aldeano = new Aldeano(this.casilleroMock);
		PlazaCentral plaza = new PlazaCentral(cajaMock, mapaMock, jugadorMock);

		Mockito.doCallRealMethod().when(aldeanoMock).repararEdificio(plaza);
		aldeanoMock.repararEdificio(plaza);

		Mockito.verify(aldeanoMock, Mockito.times(1)).recolectarOro();
	}

 	@Test(expected = CajaNoEstaPegadaAAldeano.class)
	public void aldeanoConstruyePlazaEnCajaNoAdyacenteLanzaCajaNoEstaPegadaAAldeano() throws casilleroEstaOcupado,CajaNoEstaPegadaAAldeano, SuperaLimitePoblacional, cajaEstaOcupada, casilleroInvalido, PiezaDeshabilitadaEnTurno
	{
		Casillero casilleroAldeano =  mapa.obtenerCasillero(0,0);
		Aldeano aldeano = new Aldeano(casilleroAldeano,this.jugador);
		Casillero casilleroPlaza = mapa.obtenerCasillero(2,2);
		aldeano.construirPlazaCentral(casilleroPlaza,this.mapa,this.jugador);
	}

	@Test(expected = CajaNoEstaPegadaAAldeano.class)
	public void aldeanoConstruyeCuartelEnCajaNoAdyacenteLanzaCajaNoEstaPegadaAAldeano() throws casilleroEstaOcupado,CajaNoEstaPegadaAAldeano, SuperaLimitePoblacional, cajaEstaOcupada, casilleroInvalido, PiezaDeshabilitadaEnTurno
	{
		Casillero casilleroAldeano =  mapa.obtenerCasillero(0,0);
		Aldeano aldeano = new Aldeano(casilleroAldeano,this.jugador);
		Casillero casilleroCuartel = mapa.obtenerCasillero(2,2);
		aldeano.construirCuartel(casilleroCuartel,this.mapa,this.jugador);
	}
}
