package jugador;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import mapa.*;
import unidades.*;
import edificios.*;
import jugador.*;

public class JugadorTest {


	@Test
	public void jugadorSeCreaConOroInicial() {
		
		Jugador jugador = new Jugador();
		Assert.assertEquals(100, jugador.obtenerOro());
	}
}
