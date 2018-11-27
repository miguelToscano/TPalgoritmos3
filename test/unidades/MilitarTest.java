 	package unidades;

import java.util.ArrayList;

import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import org.junit.Assert;
import excepciones.*;
import juego.*;

import org.junit.Test;

import edificios.Cuartel;
import mapa.*;

public class MilitarTest {
	
	private Mapa mapa; 
	private int filaDet;
	private int columnaDet;
	private Casillero celda;
	ArrayList<Casillero> lista = new ArrayList<Casillero>();
	private Jugador jugador;

	
	public  MilitarTest () throws tamanioDeMapaInvalido
	{
		mapa = new Mapa(15,15);
		filaDet = 3;
		columnaDet= 3;
		
		jugador = new Jugador();
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		lista.add(celda);
		lista.add(mapa.obtenerCasillero(filaDet+1, columnaDet));
		lista.add(mapa.obtenerCasillero(filaDet, columnaDet+1));
		lista.add(mapa.obtenerCasillero(filaDet+1, columnaDet+1));
		lista.add(mapa.obtenerCasillero(filaDet+4, columnaDet));
		
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
}
