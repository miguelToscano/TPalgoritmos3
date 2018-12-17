package entrega2;

import edificios.Castillo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.NoHaySuficienteOro;
import excepciones.SuperaLimitePoblacional;
import juego.*;
import mapa.*;
import mapa.excepcionesMapa.*;
import unidades.Aldeano;

import java.util.ArrayList;

public class Juego1_InicioTest {
	
	    private Jugador jugadorA;
	    private Jugador jugadorB;
	    private Mapa mapa;
	    private Juego juego;

	    @Before
	    public void setUp() throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, casilleroEstaOcupado, NoHaySuficienteOro {
	        this.jugadorA = new Jugador();
	        this.jugadorB = new Jugador();
	        this.juego = new Juego(this.jugadorA, this.jugadorB);
	        this.mapa = juego.getMapa();

	    }

//	    @Test
//	    public void juegoSeCreaConCastilloDeJugadorAEnEsquinaNoroeste() {
//
//	        for (int i = 0; i < 4; i++) {
//	            for (int j = 0; j < 4; j++) {
//	                Assert.assertTrue(this.mapa.obtenerElemento(i, j) instanceof Castillo);
//	                Assert.assertTrue(this.mapa.obtenerElemento(i, j).obtenerJugador() == this.jugadorA);
//	            }
//	        }
//	    }

//	    @Test
//	    public void juegoSeCreaConCastilloDeJugadorBEnEsquinaSureste() {
//	        for (int i = mapa.obtenerTamanioColumnas() - 4; i < mapa.obtenerTamanioColumnas(); i++) {
//	            for (int j = mapa.obtenerTamanioFilas() - 4; j < mapa.obtenerTamanioFilas(); j++) {
//	                Assert.assertTrue(this.mapa.obtenerElemento(i, j) instanceof Castillo);
//	                Assert.assertTrue(this.mapa.obtenerElemento(i, j).getJugador() == this.jugadorB);
//	            }
//	        }
//	    }
//
//	    @Test
//	    public void juegoSeCreaConPlazaDeJugadorAEnEsquinaSudoeste() {
//	        for (int i = mapa.obtenerTamanioFilas() - 2; i < mapa.obtenerTamanioFilas(); i++) {
//	            for (int j = 0; j < 2; j++)
//	                Assert.assertEquals(mapa.obtenerElemento(i, j), this.jugadorA.getPlazas().get(0));
//	        }
//	    }
//
//	    @Test
//	    public void juegoSeCreaConPlazaDeJugadorBEnEsquinaNoreste() {
//	        for (int i = 0; i < 2; i++) {
//	            for (int j = mapa.obtenerTamanioColumnas() - 2; j < mapa.obtenerTamanioColumnas(); j++)
//	                Assert.assertEquals(mapa.obtenerElemento(i, j), this.jugadorB.getPlazas().get(0));
//	        }
//	    }

	    @Test
	    public void juegoSeCreaCon3AldeanosParaJugadorA() {
	        Assert.assertEquals(3, this.jugadorA.cantidadDeAldeanos());
	    }

	    @Test
	    public void juegoSeCreaCon3AldeanosParaJugadorB() {
	        Assert.assertEquals(3, this.jugadorB.cantidadDeAldeanos());
	    }

	    @Test
	    public void losAldeanosDeJugadorASonCircundantesALaPlazaSudoesteInicial() throws casilleroInvalido {
	        Caja cajaPlaza = mapa.asignarCajaACasillero(mapa.obtenerCasillero(mapa.obtenerTamanioFilas() - 2, 0));
	        ArrayList<Casillero> lista = mapa.obtenerCasillerosCircundantes(cajaPlaza);
	        int contador = 0;
	        for (int i = 0; i < lista.size(); i++) {
	            if (lista.get(i).obtenerElemento() instanceof Aldeano &&
	                    lista.get(i).obtenerElemento().getJugador() == jugadorA) {
	                contador++;
	            }

	        }
	        Assert.assertEquals(3, contador);
	    }

	    @Test
	    public void losAldeanosDeJugadorASonCircundantesBLaPlazaNoresteInicial() throws casilleroInvalido {
	        Caja cajaPlaza = mapa.asignarCajaACasillero(mapa.obtenerCasillero(0, mapa.obtenerTamanioColumnas() - 2));
	        ArrayList<Casillero> lista = mapa.obtenerCasillerosCircundantes(cajaPlaza);
	        int contador = 0;
	        for (int i = 0; i < lista.size(); i++) {
	            if (lista.get(i).obtenerElemento() instanceof Aldeano &&
	                    lista.get(i).obtenerElemento().getJugador() == jugadorB) {
	                contador++;
	            }

	        }
	        Assert.assertEquals(3, contador);
	    }

	    @Test
	    public void jugadorAIniciaConElOroNecesario()
	    {
	        Assert.assertEquals(100,this.jugadorA.obtenerOro());
	    }

	    @Test
	    public void jugadorBIniciaConElOroNecesario()
	    {
	        Assert.assertEquals(100,this.jugadorB.obtenerOro());
	    }
	


}
