package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class UnidadesTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testSeMueveUnaUnidadEnTodasLasDirecciones() {
		Unidad unaUnidad = new Unidad(5, 5); // Se crea en la posicion 5,5
		
		// Se mueve hacia la izquierda
		unaUnidad.mover(0, -1);
		Assert.assertEquals(4, unaUnidad.getColumna());
		
		// Se mueve hacia arriba
		unaUnidad.mover(1, 0);
		Assert.assertEquals(6, unaUnidad.getFila());
		
		// Se mueve hacia la derecha
		unaUnidad.mover(0, 1);
		Assert.assertEquals(5, unaUnidad.getColumna());
		
		// Se mueve hacia abajo
		unaUnidad.mover(-1, 0);
		Assert.assertEquals(5,  unaUnidad.getFila());
		
		// Se mueve hacia el noreste
		unaUnidad.mover(1, 1);
		Assert.assertEquals(6, unaUnidad.getFila());
		Assert.assertEquals(6, unaUnidad.getColumna());
		
		// Se mueve hacia el sureste
		unaUnidad.mover(-1, 1);
		Assert.assertEquals(7, unaUnidad.getColumna());
		Assert.assertEquals(5, unaUnidad.getFila());
		
		// Se mueve hacia el suroeste
		unaUnidad.mover(-1, -1);
		Assert.assertEquals(6,  unaUnidad.getColumna());
		Assert.assertEquals(4, unaUnidad.getFila());
		
		// Se mueve hacia el noroeste
		unaUnidad.mover(1, -1);
		Assert.assertEquals(5, unaUnidad.getColumna());
		Assert.assertEquals(5, unaUnidad.getFila());
	}
} 
