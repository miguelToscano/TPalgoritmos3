package entrega2;

import org.junit.Assert;
import org.junit.Test;

import edificios.Castillo;
import edificios.Cuartel;
import edificios.PlazaCentral;
import excepciones.NoHaySuficienteOro;
import excepciones.SuperaLimitePoblacional;
import juego.Jugador;
import mapa.Caja;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class ReglasPoblacionTest {
	@Test
	public void crearUnidadArqueroAumentaPoblacion() throws tamanioDeMapaInvalido, casilleroEstaOcupado, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, NoHaySuficienteOro {
		Jugador jugador = new Jugador();
		Mapa mapa = new Mapa(15, 15);
		Cuartel cuartel = new Cuartel(mapa.obtenerCasillero(1, 1), mapa, jugador);		
		cuartel.crearArquero();
		
		Assert.assertEquals(1, jugador.obtenerPoblacion());
	}
	
	@Test
	public void crearUnidadEspadachinAumentaPoblacion() throws casilleroEstaOcupado, tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, NoHaySuficienteOro {
		
		Jugador jugador = new Jugador();
		Mapa mapa = new Mapa(20, 20);
		Cuartel cuartel = new Cuartel(mapa.obtenerCasillero(1, 1), mapa, jugador);
	
		cuartel.crearEspadachin();
		
		Assert.assertEquals(1, jugador.obtenerPoblacion());
	}
	
	@Test(expected = SuperaLimitePoblacional.class)
	public void crearArqueroCuandoSeAlcanzaElLimitePoblacionalArrojaExcepcion() throws casilleroEstaOcupado, SuperaLimitePoblacional, casilleroInvalido, cajaEstaOcupada, tamanioDeMapaInvalido, NoHaySuficienteOro {
		
		Jugador jugador = new Jugador();
		Mapa mapa = new Mapa(20, 20);
		Cuartel cuartel = new Cuartel(mapa.obtenerCasillero(1, 1), mapa, jugador);
		jugador.establecerPoblacion(50);
		cuartel.crearArquero();
	}
	
	@Test(expected = SuperaLimitePoblacional.class)
	public void crearAldeanoCuandoSeAlcanzaElLimitePoblacionalArrojaExcepcion() throws casilleroEstaOcupado, SuperaLimitePoblacional, casilleroInvalido, cajaEstaOcupada, tamanioDeMapaInvalido, NoHaySuficienteOro {
		
		Jugador jugador = new Jugador();
		Mapa mapa = new Mapa(20, 20);
		PlazaCentral plaza = new PlazaCentral(mapa.obtenerCasillero(1, 1), mapa, jugador);
		jugador.establecerPoblacion(50);
		plaza.crearAldeano();
	}
	
	@Test(expected = SuperaLimitePoblacional.class)
	public void crearArmaDeAsedioCuandoSeAlcanzaElLimitePoblacionalArrojaExcepcion() throws casilleroEstaOcupado, SuperaLimitePoblacional, casilleroInvalido, cajaEstaOcupada, tamanioDeMapaInvalido, NoHaySuficienteOro {
		
		Jugador jugador = new Jugador();
		Mapa mapa = new Mapa(20, 20);
		Caja caja = mapa.asignarCajaACasillero(mapa.obtenerCasillero(1, 1));
	    Castillo castillo = new Castillo(caja, mapa, jugador);
		jugador.establecerPoblacion(50);
		castillo.crearArmaDeAsedio();
	}
	

}
