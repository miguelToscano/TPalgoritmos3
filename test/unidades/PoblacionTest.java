package unidades;

import org.junit.Assert;
import org.junit.Test;

import excepciones.SuperaLimitePoblacional;
import juego.Jugador;
import mapa.Mapa;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
public class PoblacionTest {

	@Test
	public void crearAldeanoAumentaPoblacion() throws casilleroEstaOcupado, SuperaLimitePoblacional, tamanioDeMapaInvalido {
	
		int fila = 1;
		int columna = 2;
		Mapa unMapa = new Mapa(15, 15);
		Jugador unJugador = new Jugador();
		Aldeano unAldeano = new Aldeano(fila, columna, unMapa, unJugador);
		
		Assert.assertEquals(1, unJugador.obtenerPoblacion());
	}

	@Test
	public void crearEspadachinAumentaPoblacion() throws casilleroEstaOcupado, SuperaLimitePoblacional, tamanioDeMapaInvalido {
	
		int fila = 1;
		int columna = 2;
		Mapa unMapa = new Mapa(15, 15);
		Jugador unJugador = new Jugador();
		Espadachin unEspadachin = new Espadachin(fila, columna, unMapa, unJugador);
		
		Assert.assertEquals(1, unJugador.obtenerPoblacion());
	}
	
	@Test
	public void crearArqueroAumentaPoblacion() throws casilleroEstaOcupado, SuperaLimitePoblacional, tamanioDeMapaInvalido {
	
		int fila = 1;
		int columna = 2;
		Mapa unMapa = new Mapa(15, 15);
		Jugador unJugador = new Jugador();

		Arquero unArquero= new Arquero(fila, columna, unMapa, unJugador);
		
		Assert.assertEquals(1, unJugador.obtenerPoblacion());
	}
	
	@Test
	public void crearArmaDeAsedioAumentaPoblacion() throws casilleroEstaOcupado, SuperaLimitePoblacional, tamanioDeMapaInvalido {
	
		int fila = 1;
		int columna = 2;
		Mapa unMapa = new Mapa(15, 15);
		Jugador unJugador = new Jugador();
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(fila, columna, unMapa, unJugador);
		
		Assert.assertEquals(1, unJugador.obtenerPoblacion());
	}
	
	@Test
	public void matarAldeanoReducePoblacion() throws casilleroEstaOcupado, SuperaLimitePoblacional, tamanioDeMapaInvalido {
		
		Jugador jugador = new Jugador();
		int fila = 0;
		int columna = 0;
		Mapa unMapa = new Mapa(15, 15);
		Aldeano aldeano = new Aldeano(fila, columna, unMapa, jugador);
	
		Assert.assertEquals(1, jugador.obtenerPoblacion());
		
		aldeano.matar();
		
		Assert.assertEquals(0, jugador.obtenerPoblacion());
	}
	
	public void matarArqueroReducePoblacion() throws casilleroEstaOcupado, SuperaLimitePoblacional, tamanioDeMapaInvalido {
		
		Jugador jugador = new Jugador();
		int fila = 0;
		int columna = 0;
		Mapa unMapa = new Mapa(15, 15);
		Arquero arquero = new Arquero(fila, columna, unMapa, jugador);
	
		Assert.assertEquals(1, jugador.obtenerPoblacion());
		
		arquero.matar();
		
		Assert.assertEquals(0, jugador.obtenerPoblacion());
	}
	
	@Test
	public void matarEspadachinReducePoblacion() throws casilleroEstaOcupado, SuperaLimitePoblacional, tamanioDeMapaInvalido {
		
		Jugador jugador = new Jugador();
		int fila = 0;
		int columna = 0;
		Mapa unMapa = new Mapa(15, 15);
		Espadachin espadachin= new Espadachin(fila, columna, unMapa, jugador);
	
		Assert.assertEquals(1, jugador.obtenerPoblacion());
		
		espadachin.matar();
		
		Assert.assertEquals(0, jugador.obtenerPoblacion());
	}
	
	@Test
	public void matarArmaDeAsedioReducePoblacion() throws casilleroEstaOcupado, SuperaLimitePoblacional, tamanioDeMapaInvalido {

		Jugador jugador = new Jugador();
		int fila = 0;
		int columna = 0;
		Mapa unMapa = new Mapa(15, 15);
		ArmaDeAsedio armaDeAsedio= new ArmaDeAsedio(fila, columna, unMapa, jugador);
	
		Assert.assertEquals(1, jugador.obtenerPoblacion());
		
		armaDeAsedio.matar();
		
		Assert.assertEquals(0, jugador.obtenerPoblacion());		
	}
	
	@Test
	public void matarAldeanoBajaProduccionDeOro() throws casilleroEstaOcupado, SuperaLimitePoblacional, tamanioDeMapaInvalido {
		
		Jugador jugador = new Jugador();
		int fila = 0;
		int columna = 0;
		Mapa unMapa = new Mapa(15, 15);
		Aldeano aldeano = new Aldeano(fila, columna, unMapa, jugador);
	
		Assert.assertEquals(100, jugador.obtenerOro());		
		aldeano.recolectarOro();
		Assert.assertEquals(125, jugador.obtenerOro());
		aldeano.matar();
		aldeano.recolectarOro();
		Assert.assertEquals(125, jugador.obtenerOro());
	}

}
	
	
	
	
	
	
	
