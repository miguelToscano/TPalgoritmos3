package edificios;


import org.junit.Before;
import org.junit.Test;

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

public class CastilloTest
{
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
    public void castilloSeCreaConCajaPasadaPorParametro() throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada
    {
        Assert.assertEquals(caja,castillo.obtenerEspacioOcupado());
    }


    @Test(expected = casilleroEstaOcupado.class)
    public void crearArmaDeAsedioLanzaExcepcionSiCasilleroEstaOcupado() throws casilleroEstaOcupado, SuperaLimitePoblacional, NoHaySuficienteOro
    {
        castillo.crearArmaDeAsedio();
        castillo.crearArmaDeAsedio(); //como el arma de asedio no se movio la
                                        // crea en el mismo lugar(puntoRally)
    }

    @Test
    public void tieneArmaDeAsedio() throws casilleroEstaOcupado, SuperaLimitePoblacional, NoHaySuficienteOro
    {
        castillo.crearArmaDeAsedio();
        Assert.assertTrue(castillo.tieneArmaDeAsedio());
    }

    @Test
    public void atacaUnidadesCircundantes() throws cajaEstaOcupada, casilleroInvalido, tamanioDeMapaInvalido, casilleroEstaOcupado, SuperaLimitePoblacional
    {
    	Jugador unJugador = new Jugador();  
    	Aldeano unAldeano1 = new Aldeano(4, 4, this.mapa, unJugador);
    	Aldeano unAldeano2 = new Aldeano(5, 4, this.mapa, unJugador);
    	Aldeano unAldeano3 = new Aldeano(6, 4, this.mapa, unJugador);
    	
    	this.castillo.atacarCircundantes();
    
        Assert.assertEquals(30, unAldeano1.getVida());
        Assert.assertEquals(30, unAldeano2.getVida());
        Assert.assertEquals(30, unAldeano3.getVida());
    }
    
    @Test 
    public void atacaUnidadesCircundantesMultiplesVeces() throws cajaEstaOcupada, casilleroInvalido, tamanioDeMapaInvalido, casilleroEstaOcupado, SuperaLimitePoblacional
    {
    	Jugador unJugador = new Jugador();  
    	Aldeano unAldeano1 = new Aldeano(4, 4, this.mapa, unJugador);
    	Aldeano unAldeano2 = new Aldeano(5, 4, this.mapa, unJugador);
    	Aldeano unAldeano3 = new Aldeano(6, 4, this.mapa, unJugador);
    	
    	this.castillo.atacarCircundantes();
    	this.castillo.atacarCircundantes();
  
        Assert.assertEquals(10, unAldeano1.getVida());
        Assert.assertEquals(10, unAldeano2.getVida());
        Assert.assertEquals(10, unAldeano3.getVida());
    }
    
    @Test
    public void noAtacaUnidadCircundanteAliada () throws cajaEstaOcupada, casilleroInvalido, tamanioDeMapaInvalido, casilleroEstaOcupado, SuperaLimitePoblacional
    {
    	
    	// Se crea un aldeano aliado
    	Aldeano unAldeano1 = new Aldeano(4, 4, this.mapa, this.jugador);
    	
    	this.castillo.atacarCircundantes();
    
        Assert.assertEquals(50, unAldeano1.getVida());
    }
    
    @Test
    public void noAtacaUnidadesCircundantesAliadas () throws cajaEstaOcupada, casilleroInvalido, tamanioDeMapaInvalido, casilleroEstaOcupado, SuperaLimitePoblacional
    {
    	
    	// Se crea un aldeano aliado
    	Aldeano unAldeano1 = new Aldeano(4, 4, this.mapa, this.jugador);
    	Aldeano unAldeano2 = new Aldeano(5, 4, this.mapa, this.jugador);
    	
    	this.castillo.atacarCircundantes();
    
        Assert.assertEquals(50, unAldeano1.getVida());
        Assert.assertEquals(50, unAldeano2.getVida());
    }
    
    @Test
    public void atacaUnidadesCircundantesVerticalmente() throws cajaEstaOcupada, casilleroInvalido, tamanioDeMapaInvalido, casilleroEstaOcupado, SuperaLimitePoblacional
    {
    	Jugador unJugador = new Jugador();  
    	Aldeano unAldeano1 = new Aldeano(4, 4, this.mapa, unJugador);
    	Aldeano unAldeano2 = new Aldeano(5, 4, this.mapa, unJugador);
    	Aldeano unAldeano3 = new Aldeano(6, 4, this.mapa, unJugador);
    	Aldeano unAldeano4 = new Aldeano(7, 4, this.mapa, unJugador);
    	
    	this.castillo.atacarCircundantes();
    
        Assert.assertEquals(30, unAldeano1.getVida());
        Assert.assertEquals(30, unAldeano2.getVida());
        Assert.assertEquals(30, unAldeano3.getVida());
        Assert.assertEquals(50, unAldeano4.getVida());
    }
    
    @Test
    public void atacaUnidadesCircundantesHorizontalmente() throws cajaEstaOcupada, casilleroInvalido, tamanioDeMapaInvalido, casilleroEstaOcupado, SuperaLimitePoblacional
    {
    	Jugador unJugador = new Jugador();  
    	Aldeano unAldeano1 = new Aldeano(4, 4, this.mapa, unJugador);
    	Aldeano unAldeano2 = new Aldeano(4, 5, this.mapa, unJugador);
    	Aldeano unAldeano3 = new Aldeano(4, 6, this.mapa, unJugador);
    	Aldeano unAldeano4 = new Aldeano(4, 7, this.mapa, unJugador);
    	
    	this.castillo.atacarCircundantes();
    
        Assert.assertEquals(30, unAldeano1.getVida());
        Assert.assertEquals(30, unAldeano2.getVida());
        Assert.assertEquals(30, unAldeano3.getVida());
        Assert.assertEquals(50, unAldeano4.getVida());
    }
    
    @Test
    public void ubicar() {
    }
}