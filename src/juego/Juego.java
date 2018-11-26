package juego;
import edificios.PlazaCentral;
import mapa.*;
import mapa.excepcionesMapa.*;
import juego.Jugador;

public class Juego
{
    private Mapa mapa;
    private Jugador jugadorA;
    private Jugador jugadorB;

    public Juego(Jugador jugadorA, Jugador jugadorB) throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada
    {
        this.jugadorA = jugadorA;
        this.jugadorB = jugadorB;
        this.mapa = new Mapa(15,15);
        this.crearCastillos();
        this.crearPlazas();
    }


    public void crearCastillos() throws cajaEstaOcupada
    {
       this.mapa.crearCastilloNoroeste(jugadorA);
       this.mapa.crearCastilloSureste(jugadorB);
    }

    public void crearPlazas() throws casilleroInvalido, cajaEstaOcupada
    //se crean en las otras dos esquinas
    {

        //Plaza central de jugadorA se crea en la esquina suroeste
        Casillero casilleroJugadorA = this.mapa.obtenerCasillero(this.mapa.obtenerTamanioFilas()-2,0);
        PlazaCentral plazaJugadorA = new PlazaCentral(casilleroJugadorA,this.mapa,jugadorA);
        jugadorA.agregarPlazaCentral(plazaJugadorA);

        //Plaza central de jugadorB se crea en la esquina noreste
        Casillero casilleroJugadorB = this.mapa.obtenerCasillero(0,this.mapa.obtenerTamanioColumnas()-2);
        PlazaCentral plazaJugadorB = new PlazaCentral(casilleroJugadorB,this.mapa,jugadorB);
        jugadorB.agregarPlazaCentral(plazaJugadorB);

    }

    public Mapa getMapa()
    {
        return this.mapa;
    }
}
