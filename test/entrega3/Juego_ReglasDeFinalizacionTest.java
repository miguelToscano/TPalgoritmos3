package entrega3;


import org.junit.Before;
import org.junit.Test;

import edificios.Castillo;
import excepciones.HayUnGanador;
import excepciones.NoHaySuficienteOro;
import excepciones.SuperaLimitePoblacional;
import juego.Juego;
import juego.Jugador;
import mapa.Caja;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class Juego_ReglasDeFinalizacionTest {
	
	   private Jugador jugadorA;
	    private Jugador jugadorB;
	    private Juego juego;

	    @Before
	    public void setUp() throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, casilleroEstaOcupado, NoHaySuficienteOro {
	        this.jugadorA = new Jugador();
	        this.jugadorB = new Jugador();
	        this.juego = new Juego(this.jugadorA, this.jugadorB);

	    }
	    
	    @Test(expected = HayUnGanador.class)
	    public void juegoSeFinalizaCuandoUnCastilloSeDestruyeTotalmente() throws casilleroInvalido, tamanioDeMapaInvalido, cajaEstaOcupada, HayUnGanador {
	    	
			Mapa mapa = new Mapa(20, 20);
			Caja caja = mapa.asignarCajaACasillero(mapa.obtenerCasillero(1, 1));
		    Castillo castillo = new Castillo(caja, mapa, this.jugadorA);
		    jugadorA.asignarCastillo(castillo);
		    castillo.recibirDanio(0, 1000);
		    this.juego.terminarTurno();

	    }

	   
}
