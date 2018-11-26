 	package unidades;

import java.util.ArrayList;

import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import org.junit.Assert;
import excepciones.*;
import juego.*;

import org.junit.Test;
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
	
	@Test
	public void matarAldeanoReducePoblacion() throws casilleroEstaOcupado, superaLimitePoblacional {
		
		Jugador jugador = new Jugador();
		Aldeano aldeano = new Aldeano(this.filaDet, this.columnaDet, this.mapa, jugador);
	
		Assert.assertEquals(1, jugador.obtenerPoblacion());
		
		aldeano.matar();
		
		Assert.assertEquals(0, jugador.obtenerPoblacion());
	}
	
	public void matarArqueroReducePoblacion() throws casilleroEstaOcupado, superaLimitePoblacional {
		
		Jugador jugador = new Jugador();
		Arquero arquero = new Arquero(this.filaDet, this.columnaDet, this.mapa, jugador);
	
		Assert.assertEquals(1, jugador.obtenerPoblacion());
		
		arquero.matar();
		
		Assert.assertEquals(0, jugador.obtenerPoblacion());
	}
	
	@Test
	public void matarEspadachinReducePoblacion() throws casilleroEstaOcupado, superaLimitePoblacional {
		
		Jugador jugador = new Jugador();
		Espadachin espadachin= new Espadachin(this.filaDet, this.columnaDet, this.mapa, jugador);
	
		Assert.assertEquals(1, jugador.obtenerPoblacion());
		
		espadachin.matar();
		
		Assert.assertEquals(0, jugador.obtenerPoblacion());
	}
	
	@Test
	public void matarArmaDeAsedioReducePoblacion() throws casilleroEstaOcupado, superaLimitePoblacional {

		Jugador jugador = new Jugador();
		ArmaDeAsedio armaDeAsedio= new ArmaDeAsedio(this.filaDet, this.columnaDet, this.mapa, jugador);
	
		Assert.assertEquals(1, jugador.obtenerPoblacion());
		
		armaDeAsedio.matar();
		
		Assert.assertEquals(0, jugador.obtenerPoblacion());		
	}
	
	@Test
	public void matarAldeanoBajaProduccionDeOro() throws casilleroEstaOcupado, superaLimitePoblacional {
		
		Jugador jugador = new Jugador();
		Aldeano aldeano = new Aldeano(this.filaDet, this.columnaDet, this.mapa, jugador);
	
		Assert.assertEquals(100, jugador.obtenerOro());		
		aldeano.recolectarOro();
		Assert.assertEquals(125, jugador.obtenerOro());
		aldeano.matar();
		aldeano.recolectarOro();
		Assert.assertEquals(125, jugador.obtenerOro());
	}
}
