package juego;
import org.junit.Before;

import excepciones.superaLimitePoblacional;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class TurnoTest {

	
	private Jugador p1,p2;
	private Juego juego;
	private Mapa mapa;

	
	
	@Before
    public void setUp()  throws tamanioDeMapaInvalido, casilleroInvalido,cajaEstaOcupada,superaLimitePoblacional
	{
		mapa = new Mapa(15 , 15);
		p1 = new Jugador();
		p2 = new Jugador() ;
		juego = new Juego (p1,p2);
		
		
	}
	
	
	@Test 
	public 
}
