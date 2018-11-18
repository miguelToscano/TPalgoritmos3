package unidades;
import org.junit.Assert;
import org.junit.Test;
import mapa.*;

import unidades.Aldeano;

import static org.junit.Assert.*;


public class AldeanoTest {

	private Mapa mapa; 
	private int filaDet;
	private int columnaDet;
	private Casillero celda;
	
	public AldeanoTest () {
		
		mapa = new Mapa();
		filaDet = 3;
		columnaDet= 3;
		
		}
	
	@Test
	public void seCreoAldeanoConCoordenadas() {
		
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet) );

	}
	
	@Test
	public void seCreoAldeanoConCasillero() {
		
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Aldeano aldeano = new Aldeano(celda);
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet) );

	}
	
	@Test
	public void seMueveCorrectamente1() {
		
		// y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet+1 , columnaDet) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
}
	@Test
	public void seMueveCorrectamente2() {
		
		// y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet-1 , columnaDet) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
}
	@Test
	public void seMueveCorrectamente3() {
		
		// x+1
		celda = mapa.obtenerCasillero(filaDet , columnaDet+1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet , columnaDet+1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
}
	
	@Test
	public void seMueveCorrectamente4() {
		
		// x-1
		celda = mapa.obtenerCasillero(filaDet , columnaDet-1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet , columnaDet-1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
}
	
	@Test
	public void seMueveCorrectamente5() {
		
		// x-1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet -1 );
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet-1 , columnaDet-1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
}
	@Test
	public void seMueveCorrectamente6() {
		
		// x+1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet+1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet+1 , columnaDet+1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
}
	@Test
	public void seMueveCorrectamente7() {
		
		// x+1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet+1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet-1 , columnaDet+1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
}
	@Test
	public void seMueveCorrectamente8() {
		
		// x-1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet -1 );
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet+1 , columnaDet-1 ) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
}
	
	
	
	
	
	
	
		
	
	



}
