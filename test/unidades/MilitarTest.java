 	package unidades;

import java.util.ArrayList;

import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edificios.Cuartel;
import mapa.*;
import excepciones.FueraDeRango;
import excepciones.UnidadAliada;
import excepciones.superaLimitePoblacional;
import juego.Jugador;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class MilitarTest {
	
	private Mapa mapa; 
	private int filaDet;
	private int columnaDet;
	private Casillero celda;
	private ArrayList<Casillero> lista = new ArrayList<Casillero>();
	private Jugador jugador;
	private Caja caja;

	@Before
    public void setUp()  throws tamanioDeMapaInvalido, casilleroInvalido
	{
		mapa = new Mapa(13 , 13);
		filaDet = 3;
		columnaDet= 3;
		
		jugador = new Jugador();
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		lista.add(celda);
		lista.add(mapa.obtenerCasillero(filaDet+1, columnaDet));
		lista.add(mapa.obtenerCasillero(filaDet, columnaDet+1));
		lista.add(mapa.obtenerCasillero(filaDet+1, columnaDet+1));
		lista.add(mapa.obtenerCasillero(filaDet+4, columnaDet));
		lista.add(mapa.obtenerCasillero(filaDet+2, columnaDet+2) );
		Caja caja = mapa.asignarCajaACasillero(celda);
		
		
	}
	
	
	@Test
	public void ArqueroAtacaAldeano() throws UnidadAliada, casilleroEstaOcupado,FueraDeRango,superaLimitePoblacional
	{
		Aldeano objetivo = new Aldeano(lista.get(0), jugador); // aldeano en 3 3;
		Arquero arquero = new Arquero (lista.get(1) , jugador);
		arquero.atacar(objetivo);
        Assert.assertEquals(objetivo.getVida(), 50-15 );

	}
	
	@Test
	public void ArquerosVariosAtacanAldeano() throws UnidadAliada, casilleroEstaOcupado,FueraDeRango,superaLimitePoblacional
	{
		Aldeano objetivo = new Aldeano(lista.get(0), jugador); // aldeano en 3 3;
		Arquero arquero = new Arquero (lista.get(1), jugador);
		Arquero arqueroBis = new Arquero (lista.get(2),jugador );
		arquero.atacar(objetivo);
		arqueroBis.atacar(objetivo);
        Assert.assertEquals(objetivo.getVida(), 50-30 );

	}
	
	@Test
	public void ArquerosVariosAtacanyMatanAldeano() throws UnidadAliada, casilleroEstaOcupado,FueraDeRango,superaLimitePoblacional
	{
		Aldeano objetivo = new Aldeano(lista.get(0), jugador); // aldeano en 3 3;
		Arquero arquero = new Arquero (lista.get(1) , jugador);
		Arquero arqueroBis = new Arquero (lista.get(2),jugador);
		arquero.atacar(objetivo);
		arquero.atacar(objetivo);
		arqueroBis.atacar(objetivo);
		arqueroBis.atacar(objetivo);
        Assert.assertEquals(objetivo.getVida(), 0);

	}
	
	@Test(expected = FueraDeRango.class)
	public void ArqueroFueraDeRangoLanzaExcepcion() throws UnidadAliada, casilleroEstaOcupado,FueraDeRango,superaLimitePoblacional
	{
		Aldeano objetivo = new Aldeano(lista.get(0), jugador); // aldeano en 3 3;
		Arquero arquero = new Arquero (lista.get(4),jugador);
		arquero.atacar(objetivo);
	}

	
	
	@Test
	public void ArqueroAtacaEdificioQueEstaEnRango () throws cajaEstaOcupada,superaLimitePoblacional,casilleroEstaOcupado,FueraDeRango , UnidadAliada
	
	{
		Cuartel cuartel = new Cuartel (this.caja, mapa , jugador); //3 3 y 4 4 y 3 4 y 4 3 .
		Arquero arquero = new Arquero (lista.get(5) , jugador); //5 5 
		
		int vidaPreAtaque = cuartel.getVida();
		arquero.atacar(cuartel);
		
        Assert.assertEquals(cuartel.getVida(), vidaPreAtaque-10 );


		
	}
	
	@Test
	public void ArmaAsedioAtacaEdificioQueEstaEnRango () throws cajaEstaOcupada,superaLimitePoblacional,casilleroEstaOcupado,FueraDeRango , UnidadAliada
	
	{
		Cuartel cuartel = new Cuartel (caja, mapa , jugador); //3 3 y 4 4 y 3 4 y 4 3 .
		ArmaDeAsedio asedio = new ArmaDeAsedio (mapa.obtenerCasillero(7, 8) , jugador); //5 5 
		
		int vidaPreAtaque = cuartel.getVida();
		asedio.atacar(cuartel);
        Assert.assertEquals(cuartel.getVida(), vidaPreAtaque-75 );


		
	}
	
	@Test
	public void EspadachinAtacaEdificioQueEstaEnRango () throws cajaEstaOcupada,superaLimitePoblacional,casilleroEstaOcupado,FueraDeRango , UnidadAliada
	
	{
		Cuartel cuartel = new Cuartel (caja, mapa , jugador); //3 3 y 4 4 y 3 4 y 4 3 .
		Espadachin militar = new Espadachin (mapa.obtenerCasillero(7, 8) , jugador); //5 5 
		
		int vidaPreAtaque = cuartel.getVida();
		militar.atacar(cuartel);
        Assert.assertEquals(cuartel.getVida(), vidaPreAtaque-15 );


		
	}
	@Test
	public void ArqueroAtacaEdificioQueEstaParcialmenteEnRango () throws cajaEstaOcupada,superaLimitePoblacional,casilleroEstaOcupado,FueraDeRango , UnidadAliada
	
	{
		Cuartel cuartel = new Cuartel (this.caja, mapa , jugador); //3 3 y 4 4 y 3 4 y 4 3 .
		Arquero arquero = new Arquero (7,7, mapa , jugador); //7 7
		
		int vidaPreAtaque = cuartel.getVida();
		arquero.atacar(cuartel);
		
        Assert.assertEquals(cuartel.getVida(), vidaPreAtaque-10 );


		
	}
	
	@Test
	public void ArmaAsedioAtacaEdificioQueEstaParcialmenteEnRango () throws cajaEstaOcupada,superaLimitePoblacional,casilleroEstaOcupado,FueraDeRango , UnidadAliada
	
	{
		Cuartel cuartel = new Cuartel (caja, mapa , jugador); //3 3 y 4 4 y 3 4 y 4 3 .
		ArmaDeAsedio asedio = new ArmaDeAsedio (9,9,mapa , jugador); //5 5 
		
		int vidaPreAtaque = cuartel.getVida();
		asedio.atacar(cuartel);
        Assert.assertEquals(cuartel.getVida(), vidaPreAtaque-75 );


	}
	
	
	@Test(expected = FueraDeRango.class)

	public void ArmaAsedioAtacaEdificioQueEstaFueraEnRango () throws cajaEstaOcupada,superaLimitePoblacional,casilleroEstaOcupado,FueraDeRango , UnidadAliada
	
	{
		Cuartel cuartel = new Cuartel (caja, mapa , jugador); //3 3 y 4 4 y 3 4 y 4 3 .
		ArmaDeAsedio asedio = new ArmaDeAsedio (10,10,mapa, jugador); //5 5 
		
		int vidaPreAtaque = cuartel.getVida();
		asedio.atacar(cuartel);
        


	}	
	
	

}



