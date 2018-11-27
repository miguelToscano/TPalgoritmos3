package juego;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GestorDeTurnosTest {
	
	private Jugador jugadorMockA= Mockito.mock(Jugador.class);
	private Jugador jugadorMockB= Mockito.mock(Jugador.class);
	private GestorDeTurno gestorMock= Mockito.mock(GestorDeTurno.class);
	private int turno=1;
	
	GestorDeTurno gestor= new GestorDeTurno(jugadorMockA, jugadorMockB, turno);
	
	  @Test
	  public void finalizadoElTurnoSeCambiaDeJugador() {
		  
		  Jugador primerJugador = this.gestor.obtenerPrimerJugador();
		  this.gestor.finalizarTurno();
		  
		  Assert.assertTrue(this.gestor.obtenerJugadorSiguiente()!=primerJugador);
	  }
	  
		
	  @Test
	  public void finalizadoElTurnoSeIncrementaNumeroTurno() {
		  
		  int numeroTurnoAlPpio = this.gestor.obtenerTurnoActual();
		  this.gestor.finalizarTurno();
		  
		  Assert.assertTrue(numeroTurnoAlPpio<this.gestor.obtenerTurnoActual());
	  }
}
