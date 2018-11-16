package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class MapaTest {

	@Test
	public void mapaTieneTamanioEspecificadoTest() {
		
		// Crea un mapa de 5x5
		Mapa unMapa = new Mapa(5, 5);
		
		Assert.assertEquals(5, unMapa.getFilas());
		Assert.assertEquals(5, unMapa.getColumnas());
	}
	
	
}
