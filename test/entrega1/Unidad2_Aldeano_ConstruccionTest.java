package entrega1;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

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
import unidades.Aldeano;

public class Unidad2_Aldeano_ConstruccionTest {

	Casillero casilleroMock = Mockito.mock(Casillero.class);
	Caja cajaMock = Mockito.mock(Caja.class);
	Mapa mapaMock = Mockito.mock(Mapa.class);
	Jugador jugadorMock = Mockito.mock(Jugador.class);
	PlazaCentral plazaMock = Mockito.mock(PlazaCentral.class);

	@Test
	public void aldeanoComienzaAConstruirPlaza()
			throws casilleroEstaOcupado, casilleroInvalido, superaLimitePoblacional, cajaEstaOcupada, PiezaDeshabilitadaEnTurno {
		Aldeano aldeano = new Aldeano(this.casilleroMock, this.jugadorMock);

		aldeano.construirPlazaCentral(this.cajaMock, this.mapaMock, this.jugadorMock);

		Assert.assertFalse(aldeano.obtenerEdificioEnConstruccion() == null);
	}
	
	@Test
	public void aldeanoComienzaAConstruirCuartel()
			throws casilleroEstaOcupado, casilleroInvalido, superaLimitePoblacional, cajaEstaOcupada, PiezaDeshabilitadaEnTurno {
		Aldeano aldeano = new Aldeano(this.casilleroMock, this.jugadorMock);

		aldeano.construirCuartel(this.cajaMock, this.mapaMock, this.jugadorMock);

		Assert.assertFalse(aldeano.obtenerEdificioEnConstruccion() == null);
	}

	@Test
	public void aldeanoConstruyendoEstaTrabajando()
			throws cajaEstaOcupada, superaLimitePoblacional, casilleroEstaOcupado, PiezaDeshabilitadaEnTurno {

		Aldeano aldeano = new Aldeano(this.casilleroMock, this.jugadorMock);

		aldeano.construirPlazaCentral(this.cajaMock, this.mapaMock, this.jugadorMock);

		Assert.assertTrue(aldeano.trabajando == true);
	}

	@Test
	public void aldeanoConstruyendoNoProduceOro() throws casilleroInvalido, cajaEstaOcupada, superaLimitePoblacional, PiezaDeshabilitadaEnTurno {

		Aldeano aldeanoMock = Mockito.mock(Aldeano.class);
		aldeanoMock.construirPlazaCentral(this.cajaMock, this.mapaMock, this.jugadorMock);

		Mockito.verify(aldeanoMock, Mockito.times(0)).recolectarOro();

	}
	
	  @Test(expected = PiezaDeshabilitadaEnTurno.class)
	    public void noPuedeConstruirDosVecesEnUnTurno() throws casilleroEstaOcupado, superaLimitePoblacional, cajaEstaOcupada, PiezaDeshabilitadaEnTurno {
		  
		  Aldeano aldeano = new Aldeano(this.casilleroMock, this.jugadorMock);
		  aldeano.construirPlazaCentral(this.cajaMock, this.mapaMock, this.jugadorMock);
		  aldeano.construirCuartel(this.cajaMock, this.mapaMock, this.jugadorMock);
	    }
	  
	  @Test(expected = PiezaDeshabilitadaEnTurno.class)
	    public void noPuedeMoveryConstruir() throws casilleroEstaOcupado, superaLimitePoblacional, cajaEstaOcupada, PiezaDeshabilitadaEnTurno, MovimientoInvalido, NoEsElTurnoDelJugador {
		  
		  Aldeano aldeano = new Aldeano(this.casilleroMock, this.jugadorMock);
		  aldeano.construirPlazaCentral(this.cajaMock, this.mapaMock, this.jugadorMock);
		  aldeano.mover(this.casilleroMock);
	    }


}
