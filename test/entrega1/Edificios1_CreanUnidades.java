package entrega1;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edificios.Castillo;
import edificios.Cuartel;
import edificios.PlazaCentral;
import excepciones.NoHaySuficienteOro;
import excepciones.SuperaLimitePoblacional;
import juego.Jugador;
import junit.framework.Assert;
import mapa.Caja;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import unidades.Aldeano;

public class Edificios1_CreanUnidades {
	 
	
	private Caja caja;
    private Mapa mapa;
    private Casillero celda;
    private Castillo castillo;
    private Jugador jugador;

    @Before
    public  void setUp () throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional
    {
    	this.jugador = new Jugador();
        this.mapa = new Mapa(15,15);
        this.celda = mapa.obtenerCasillero(0, 0);
        this.caja = mapa.asignarCajaACasillero(celda);
        this.castillo = new Castillo(this.caja,this.mapa,this.jugador);
    }
    
    @Test
    public void castilloCrearArmaDeAsedio() throws casilleroEstaOcupado, SuperaLimitePoblacional, NoHaySuficienteOro
    {
        castillo.crearArmaDeAsedio();
        
        Assert.assertTrue(castillo.tieneArmaDeAsedio() == true);
    }

    @Test
    public void plazaCreaAldeano() throws casilleroInvalido, casilleroEstaOcupado, cajaEstaOcupada,
                                                    tamanioDeMapaInvalido, SuperaLimitePoblacional, NoHaySuficienteOro
    {
        Mapa mapa = new Mapa(15,15);
        Casillero casillero = mapa.obtenerCasillero(3,2);
        PlazaCentral plaza = new PlazaCentral (casillero,mapa,this.jugador);
    	plaza.crearAldeano();
    	casillero = plaza.getPuntoRally();
    	ArrayList<Aldeano> aldeanos = plaza.getAldeanos();
    	
    	Assert.assertEquals(aldeanos.get(0) , casillero.obtenerElemento());

    }
    
    @Test
	public void cuartelCrearArquero() throws tamanioDeMapaInvalido, casilleroEstaOcupado, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, NoHaySuficienteOro {
		Jugador jugador = new Jugador();
		Mapa mapa = new Mapa(15, 15);
		Cuartel cuartel = new Cuartel(mapa.obtenerCasillero(1, 1), mapa, jugador);
		jugador.agregarCuartel(cuartel);
		cuartel.crearArquero();
		
		 Assert.assertTrue(cuartel.tieneArquero());
	}
	
	@Test
	public void cuartelCrearEspadachin() throws casilleroEstaOcupado, tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, NoHaySuficienteOro {
		
		Jugador jugadorA = new Jugador();
		Mapa mapa = new Mapa(20, 20);
		Cuartel cuartel = new Cuartel(mapa.obtenerCasillero(1, 1), mapa, jugadorA);
		cuartel.crearEspadachin();
		
		 Assert.assertTrue(cuartel.tieneEspadachin());
	}
}
