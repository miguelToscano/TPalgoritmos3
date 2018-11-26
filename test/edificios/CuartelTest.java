package edificios;

import java.util.ArrayList;

import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import org.junit.Assert;
import excepciones.*;
import org.junit.Test;
import mapa.*;
import jugador.*;
import edificios.*;
import unidades.*;

import org.junit.Test;

public class CuartelTest {
	
	@Test
	public void crearUnidadArqueroAumentaPoblacion() throws tamanioDeMapaInvalido, casilleroEstaOcupado, casilleroInvalido, cajaEstaOcupada {
		Jugador jugador = new Jugador();
		Mapa mapa = new Mapa(15, 15);
		Cuartel cuartel = new Cuartel(mapa.obtenerCasillero(1, 1), mapa, jugador);		
		cuartel.crearArquero();
		
		Assert.assertEquals(1, jugador.getPoblacion());
	}
	
	@Test
	public void crearUnidadEspadachinAumentaPoblacion() throws casilleroEstaOcupado, tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada {
		
		Jugador jugador = new Jugador();
		Mapa mapa = new Mapa(20, 20);
		Cuartel cuartel = new Cuartel(mapa.obtenerCasillero(1, 1), mapa, jugador);
	
		cuartel.crearEspadachin();
		
		Assert.assertEquals(1, jugador.getPoblacion());
	}
}
