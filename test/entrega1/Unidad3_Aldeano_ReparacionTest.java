package entrega1;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import edificios.Cuartel;
import edificios.PlazaCentral;
import excepciones.SuperaLimitePoblacional;
import juego.Jugador;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import unidades.Aldeano;

public class Unidad3_Aldeano_ReparacionTest {
	
	Casillero casilleroMock = Mockito.mock(Casillero.class);
	Caja cajaMock = Mockito.mock(Caja.class);
	Mapa mapaMock = Mockito.mock(Mapa.class);
	Jugador jugadorMock = Mockito.mock(Jugador.class);
	PlazaCentral plazaMock = Mockito.mock(PlazaCentral.class);

	@Test
	public void aldeanoReparacionCompleta() throws casilleroEstaOcupado, cajaEstaOcupada, SuperaLimitePoblacional {

		Aldeano aldeano = new Aldeano(this.casilleroMock, jugadorMock);
		Cuartel cuartel = new Cuartel(cajaMock, mapaMock, jugadorMock);

		cuartel.recibirDanio(0,50);
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

}
