package unidades;

import java.util.ArrayList;

import org.junit.Assert;
import excepciones.*;
import org.junit.Test;
import mapa.*;
import edificios.*;
import unidades.*;

public class MilitarTest {
	
	private Mapa mapa; 
	private int filaDet;
	private int columnaDet;
	private Casillero celda;
	ArrayList<Casillero> lista = new ArrayList<Casillero>();
	
	
	public  MilitarTest ()
	{
		mapa = new Mapa(10,10);
		filaDet = 3;
		columnaDet= 3;
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		lista.add(celda);
		lista.add(mapa.obtenerCasillero(filaDet+1, columnaDet));
		lista.add(mapa.obtenerCasillero(filaDet, columnaDet+1));
		lista.add(mapa.obtenerCasillero(filaDet+1, columnaDet+1));
		lista.add(mapa.obtenerCasillero(filaDet+4, columnaDet));


		
	}
	
	
	@Test
	public void ArqueroAtacaAldeano() throws UnidadAliada,CasilleroLleno,FueraDeRango
	{
		Aldeano objetivo = new Aldeano(lista.get(0)); // aldeano en 3 3;
		Arquero arquero = new Arquero (lista.get(1));
		arquero.atacar(objetivo);
        Assert.assertEquals(objetivo.getVida(), 50-15 );

	}
	
	@Test
	public void ArquerosVariosAtacanAldeano() throws UnidadAliada,CasilleroLleno,FueraDeRango
	{
		Aldeano objetivo = new Aldeano(lista.get(0)); // aldeano en 3 3;
		Arquero arquero = new Arquero (lista.get(1));
		Arquero arqueroBis = new Arquero (lista.get(2));
		arquero.atacar(objetivo);
		arqueroBis.atacar(objetivo);
        Assert.assertEquals(objetivo.getVida(), 50-30 );

	}
	
	@Test
	public void ArquerosVariosAtacanyMatanAldeano() throws UnidadAliada,CasilleroLleno,FueraDeRango
	{
		Aldeano objetivo = new Aldeano(lista.get(0)); // aldeano en 3 3;
		Arquero arquero = new Arquero (lista.get(1));
		Arquero arqueroBis = new Arquero (lista.get(2));
		arquero.atacar(objetivo);
		arquero.atacar(objetivo);
		arqueroBis.atacar(objetivo);
		arqueroBis.atacar(objetivo);
        Assert.assertEquals(objetivo.getVida(), 50-60 );

	}
	
	@Test(expected = FueraDeRango.class)
	public void ArqueroFueraDeRangoLanzaExcepcion() throws UnidadAliada,CasilleroLleno,FueraDeRango
	{
		Aldeano objetivo = new Aldeano(lista.get(0)); // aldeano en 3 3;
		Arquero arquero = new Arquero (lista.get(4));
		arquero.atacar(objetivo);
		

	}
	
}
