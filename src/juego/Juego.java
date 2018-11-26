package juego;
import mapa.Mapa;
import mapa.excepcionesMapa.*;
import juego.Jugador;

public class Juego
{
    private Mapa mapa;
    private Jugador jugadorA;
    private Jugador jugadorB;

    public Juego(Jugador jugadorA, Jugador jugadorB) throws tamanioDeMapaInvalido
    {
        this.jugadorA = jugadorA;
        this.jugadorB = jugadorB;
        mapa = new Mapa(15,15);
        this.crearCastilloJugadorA();
        this.crearCastilloJugadorB();
    }

    public void crearCastilloJugadorA()
    {
       this.mapa.crearCastilloSuperior(jugadorA);
    }

    public void crearCastilloJugadorB()
    {
        this.mapa.crearCastilloInferior(jugadorB);
    }

    public Mapa getMapa()
    {
        return this.mapa;
    }
}
