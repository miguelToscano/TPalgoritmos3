package juego;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import excepciones.HayUnGanador;
import excepciones.superaLimitePoblacional;

import static org.junit.Assert.*;
import juego.*;

public class GestorDeTurnosTest {
	
	private Jugador jugadorMockA= Mockito.mock(Jugador.class);
	private Jugador jugadorMockB= Mockito.mock(Jugador.class);
	private GestorDeTurno gestor=null;
	
	  
	@Before
	public void setUp() {
		
		 this.gestor = new GestorDeTurno(jugadorMockA, jugadorMockB, 1);
		 this.gestor.jugadorDeTurno=jugadorMockA;
	}
	 
	  @Test
	  public void finalizadoElTurnoSeCambiaDeJugador() throws HayUnGanador {
		  
		  Jugador primerJugador = this.gestor.jugadorDeTurno;
		  this.gestor.finalizarTurno();
		  
		  Assert.assertTrue(this.gestor.jugadorDeTurno!=primerJugador);
	  }
	  
		
	  @Test
	  public void finalizadoElTurnoSeIncrementaNumeroTurno() throws HayUnGanador {
		  
		  int numeroTurnoAlPpio = this.gestor.obtenerTurnoActual();
		  this.gestor.finalizarTurno();
		  
		  Assert.assertTrue(numeroTurnoAlPpio<this.gestor.obtenerTurnoActual());
	  }
	  
	  @Test
	  public void primerTurnoJugadorAleatorio() {
		  
		  Jugador jugador = this.gestor.obtenerPrimerJugador();
		
		  Assert.assertTrue(jugador==jugadorMockA||jugador==jugadorMockB);
	  }
	  

}
