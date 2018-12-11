package entrega1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import excepciones.*;
import juego.Jugador;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.*;
import unidades.Aldeano;

public class Unidad2_Aldeano_ConstruccionTest {

	private Mapa mapa;
	private Jugador jugador;
	private Casillero unCasillero;
	private Casillero otroCasillero;
	private Casillero casilleroAldeano;
	private Aldeano aldeano;

	@Before
	public void setUp() throws tamanioDeMapaInvalido, casilleroEstaOcupado, SuperaLimitePoblacional
	{
		this.mapa = new Mapa(15, 15);
		this.jugador = new Jugador();
		this.casilleroAldeano = mapa.obtenerCasillero(3, 3);
		this.unCasillero = mapa.obtenerCasillero(3,4);
		this.otroCasillero = mapa.obtenerCasillero(4,2);
		this.aldeano = new Aldeano(this.casilleroAldeano,this.jugador);

	}


	@Test
	public void aldeanoComienzaAConstruirPlaza()
			throws casilleroInvalido, CajaNoEstaPegadaAAldeano, cajaEstaOcupada, PiezaDeshabilitadaEnTurno {

		this.aldeano.construirPlazaCentral(this.unCasillero, this.mapa, this.jugador);

		Assert.assertFalse(this.aldeano.obtenerEdificioEnConstruccion() == null);
	}
	
	@Test
	public void aldeanoComienzaAConstruirCuartel()
			throws SuperaLimitePoblacional, cajaEstaOcupada, PiezaDeshabilitadaEnTurno, casilleroInvalido, CajaNoEstaPegadaAAldeano
	{

		this.aldeano.construirCuartel(this.unCasillero, this.mapa, this.jugador);

		Assert.assertFalse(this.aldeano.obtenerEdificioEnConstruccion() == null);
	}

	@Test
	public void aldeanoConstruyendoEstaTrabajando()
			throws cajaEstaOcupada, CajaNoEstaPegadaAAldeano, casilleroInvalido, PiezaDeshabilitadaEnTurno {

		this.aldeano.construirPlazaCentral(this.otroCasillero, this.mapa, this.jugador);

		Assert.assertTrue(this.aldeano.trabajando == true);
	}

	@Test
	public void aldeanoConstruyendoNoProduceOro() throws casilleroInvalido, cajaEstaOcupada, CajaNoEstaPegadaAAldeano, PiezaDeshabilitadaEnTurno {

		Aldeano aldeanoMock = Mockito.mock(Aldeano.class);
		aldeanoMock.construirPlazaCentral(this.unCasillero, this.mapa, this.jugador);

		Mockito.verify(aldeanoMock, Mockito.times(0)).recolectarOro();

	}
	
	  @Test(expected = PiezaDeshabilitadaEnTurno.class)
	    public void noPuedeConstruirDosVecesEnUnTurno() throws CajaNoEstaPegadaAAldeano, SuperaLimitePoblacional, casilleroInvalido, cajaEstaOcupada, PiezaDeshabilitadaEnTurno {

		  this.aldeano.construirPlazaCentral(this.unCasillero, this.mapa, this.jugador);
		  this.aldeano.construirCuartel(this.otroCasillero, this.mapa, this.jugador);
	    }
	  
	  @Test(expected = PiezaDeshabilitadaEnTurno.class)
	    public void noPuedeMoveryConstruir() throws casilleroEstaOcupado, CajaNoEstaPegadaAAldeano, casilleroInvalido, cajaEstaOcupada, PiezaDeshabilitadaEnTurno, MovimientoInvalido, NoEsElTurnoDelJugador, DistanciaInvalida {

		  this.aldeano.construirPlazaCentral(this.unCasillero, this.mapa, this.jugador);
		  this.aldeano.mover(this.otroCasillero);
	    }


}
