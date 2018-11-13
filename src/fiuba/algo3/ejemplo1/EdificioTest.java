package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class EdificioTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testPlazaCentralCreaAldeano() {
		
		PlazaCentral unaPlazaCentral = new PlazaCentral();
		
		unaPlazaCentral.crearAldeano();
		
		Assert.assertEquals(true, unaPlazaCentral.creoAldeano());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCuartelCreaEspadachin() {
		
		Cuartel unCuartel = new Cuartel();
		
		unCuartel.crearEspadachin();
		
		Assert.assertEquals(true, unCuartel.creoEspadachin());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCuartelCreaArquero() {
		
		Cuartel unCuartel = new Cuartel();
		
		unCuartel.crearArquero();
		
		Assert.assertEquals(true, unCuartel.creoArquero());
	}
}
