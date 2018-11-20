package unidades;
import org.junit.Assert;
import excepciones.*;
import org.junit.Test;
import mapa.*;
import edificios.*;

import unidades.Aldeano;

import static org.junit.Assert.*;


public class AldeanoTest {

	private Mapa mapa; 
	private int filaDet;
	private int columnaDet;
	private Casillero celda;
	
	public AldeanoTest ()
	{
		mapa = new Mapa(10,10);
		filaDet = 3;
		columnaDet= 3;
	}


	@Test
	public void seCreoAldeanoConCoordenadas() throws CasilleroLleno
	{
		
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet) );

	}
	
	@Test
	public void seCreoAldeanoConCasillero() throws CasilleroLleno
	{
		
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Aldeano aldeano = new Aldeano(celda);
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet) );

	}
	
	@Test
	public void seMueveCorrectamente1() throws CasilleroLleno
	{
		
		// y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet+1 , columnaDet) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}

	@Test
	public void seMueveCorrectamente2() throws CasilleroLleno
	{
		
		// y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet-1 , columnaDet) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}

	@Test
	public void seMueveCorrectamente3() throws CasilleroLleno
	{
		
		// x+1
		celda = mapa.obtenerCasillero(filaDet , columnaDet+1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet , columnaDet+1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	
	@Test
	public void seMueveCorrectamente4() throws CasilleroLleno
	{
		
		// x-1
		celda = mapa.obtenerCasillero(filaDet , columnaDet-1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet , columnaDet-1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	
	@Test
	public void seMueveCorrectamente5() throws CasilleroLleno
	{
		
		// x-1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet -1 );
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet-1 , columnaDet-1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	@Test
	public void seMueveCorrectamente6() throws CasilleroLleno
	{
		
		// x+1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet+1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet+1 , columnaDet+1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	@Test
	public void seMueveCorrectamente7() throws CasilleroLleno
	{
		
		// x+1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet+1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet-1 , columnaDet+1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	@Test
	public void seMueveCorrectamente8() throws CasilleroLleno
	{
		
		// x-1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet -1 );
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet+1 , columnaDet-1 ) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	
@Test(expected = CasilleroLleno.class)
	
	public void seCreaEnLugarOcupadoPorUnidadLanzaExcepcion () throws CasilleroLleno
	{
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Aldeano aldeano = new Aldeano(celda);
		Aldeano aldeanoBis = new Aldeano(celda);


	}
	
	@Test(expected = CasilleroLleno.class)
	public void seMueveAUnLugarOcupadoPorUnidadLanzaExcepcion () throws CasilleroLleno
	{
		celda = mapa.obtenerCasillero(filaDet+1, columnaDet+1);
		Casillero celdaBis = mapa.obtenerCasillero(filaDet, columnaDet);

		Aldeano aldeano = new Aldeano(celda);
		Aldeano aldeanoBis = new Aldeano(celdaBis);
		
		aldeanoBis.mover(celda);

	}
	@Test(expected = CasilleroLleno.class)
	public void seCreaEnUnLugarOcupadoPorEdificioLanzaExcepcion () throws CasilleroLleno,casilleroInvalido
	{
		//creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel (caja);
		
		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Aldeano aldeano = new Aldeano(mapa.obtenerCasillero(6, 7));
		
		
	}
	
	@Test(expected = CasilleroLleno.class)
	public void seMueveAUnLugarOcupadoPorEdificioLanzaExcepcion () throws CasilleroLleno,casilleroInvalido
	{
		//creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel (caja);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Aldeano aldeano = new Aldeano(mapa.obtenerCasillero(5, 5));
		aldeano.mover(celda);
		
		
	}

}
