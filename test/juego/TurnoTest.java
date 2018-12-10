package juego;
import org.junit.Before;

import excepciones.SuperaLimitePoblacional;
import mapa.Mapa;
import mapa.excepcionesMapa.*;

public class TurnoTest {

	
	private Jugador p1,p2;
	private Juego juego;
	private Mapa mapa;

	
	
	@Before
    public void setUp()  throws tamanioDeMapaInvalido, casilleroInvalido,cajaEstaOcupada, SuperaLimitePoblacional, casilleroEstaOcupado
	{
		mapa = new Mapa(15 , 15);
		p1 = new Jugador();
		p2 = new Jugador() ;
		juego = new Juego (p1,p2);
		
		
	}

}
