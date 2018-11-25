package unidades;
import mapa.excepcionesMapa.*;
import mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;
import mapa.*;
import edificios.*;


public class AldeanoTest {

	private Mapa mapa; 
	private int filaDet;
	private int columnaDet;
	private Casillero celda;
	
	public AldeanoTest () throws tamanioDeMapaInvalido
	{
		mapa = new Mapa(15,15);
		filaDet = 3;
		columnaDet= 3;
	}


	@Test
	public void seCreoAldeanoConCoordenadas() throws casilleroLleno
	{
		
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet) );

	}
	
	@Test
	public void seCreoAldeanoConCasillero() throws casilleroLleno
	{
		
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Aldeano aldeano = new Aldeano(celda);
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet) );

	}
	
	@Test
	public void seMueveCorrectamente1() throws casilleroLleno
	{
		
		// y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet+1 , columnaDet) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}

	@Test
	public void seMueveCorrectamente2() throws casilleroLleno
	{
		
		// y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet-1 , columnaDet) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}

	@Test
	public void seMueveCorrectamente3() throws casilleroLleno
	{
		
		// x+1
		celda = mapa.obtenerCasillero(filaDet , columnaDet+1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet , columnaDet+1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	
	@Test
	public void seMueveCorrectamente4() throws casilleroLleno
	{
		
		// x-1
		celda = mapa.obtenerCasillero(filaDet , columnaDet-1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet , columnaDet-1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	
	@Test
	public void seMueveCorrectamente5() throws casilleroLleno
	{
		
		// x-1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet -1 );
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet-1 , columnaDet-1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	@Test
	public void seMueveCorrectamente6() throws casilleroLleno
	{
		
		// x+1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet+1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet+1 , columnaDet+1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	@Test
	public void seMueveCorrectamente7() throws casilleroLleno
	{
		
		// x+1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet+1);
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet-1 , columnaDet+1) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	@Test
	public void seMueveCorrectamente8() throws casilleroLleno
	{
		
		// x-1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet -1 );
		Aldeano aldeano = new Aldeano(filaDet,columnaDet,mapa);
		aldeano.mover (celda);
		
        Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet+1 , columnaDet-1 ) );
        Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));
        
	}
	
@Test(expected = casilleroLleno.class)
	
	public void seCreaEnLugarOcupadoPorUnidadLanzaExcepcion () throws casilleroLleno
	{
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Aldeano aldeano = new Aldeano(celda);
		Aldeano aldeanoBis = new Aldeano(celda);


	}
	
	@Test(expected = casilleroLleno.class)
	public void seMueveAUnLugarOcupadoPorUnidadLanzaExcepcion () throws casilleroLleno
	{
		celda = mapa.obtenerCasillero(filaDet+1, columnaDet+1);
		Casillero celdaBis = mapa.obtenerCasillero(filaDet, columnaDet);

		Aldeano aldeano = new Aldeano(celda);
		Aldeano aldeanoBis = new Aldeano(celdaBis);
		
		aldeanoBis.mover(celda);

	}
	@Test(expected = casilleroLleno.class)
	public void seCreaEnUnLugarOcupadoPorEdificioLanzaExcepcion () throws casilleroLleno, casilleroInvalido
	{
		//creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel (caja,this.mapa);
		
		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Aldeano aldeano = new Aldeano(mapa.obtenerCasillero(6, 7));
		
		
	}
	
	@Test(expected = casilleroLleno.class)
	public void seMueveAUnLugarOcupadoPorEdificioLanzaExcepcion () throws casilleroLleno,casilleroInvalido
	{
		//creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel (caja, this.mapa);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Aldeano aldeano = new Aldeano(mapa.obtenerCasillero(5, 5));
		aldeano.mover(celda);
		
		
	}
//	@Test
//    public void aldeanoComienzaAConstruirPlaza()
//    {
//        Aldeano aldeano = new Aldeano();
//        aldeano.construirPlaza();
//        
//        Assert.assertTrue(aldeano.edificioEnConstruccion != null);
//    }
// 
//	@Test
//    public void aldeanoConstruyendoEstaTrabajando()
//    {
//        Aldeano aldeano = new Aldeano();
//        aldeano.construirPlaza();
//        
//        Assert.assertTrue(aldeano.trabajando);
//    }
// 
// @Test
//    public void aldeanoConstruyendoNoProduceOro()
//    {
//        Aldeano aldeano = new Aldeano();
//        aldeano.construirPlaza();
//        
//        Assert.assertTrue(aldeano.sumarOro()==0);
//    }

}
