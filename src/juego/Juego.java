package juego;
import edificios.PlazaCentral;
import mapa.*;
import mapa.excepcionesMapa.*;
import excepciones.HayUnGanador;
import excepciones.NoHaySuficienteOro;
import excepciones.SuperaLimitePoblacional;

public class Juego
{
    private Mapa mapa;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private static int turno;
    private GestorDeTurno gestor=null;
    
    public Juego(Jugador jugadorA, Jugador jugadorB) throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, casilleroEstaOcupado, NoHaySuficienteOro
    {
        this.jugadorA = jugadorA;
        this.jugadorB = jugadorB;
        this.jugadorA.sumarOro(75);
        this.jugadorB.sumarOro(75);
        jugadorA.setJuego(this);
        jugadorB.setJuego(this);
        this.mapa = new Mapa(15,15);
        this.crearCastillos();
        this.crearPlazas();
        this.turno = 0;
        this.gestor= new GestorDeTurno(jugadorA, jugadorB, 1);
    }
    
    public Jugador obtenerJugador1() {
    	return this.jugadorA;
    }
    
    public Jugador obtenerJugador2() {
    	return this.jugadorB;
    }
    
    public void aumentarTurno()
    {
        this.turno++;
    }
    
    public int obtenerFilas() {
    	return this.mapa.obtenerTamanioFilas();
    }
    
    public int obtenerColumnas() {
    	return this.mapa.obtenerTamanioColumnas();
    }

    public void crearCastillos() throws cajaEstaOcupada, SuperaLimitePoblacional
    {
       this.mapa.crearCastilloNoroeste(jugadorA);
       this.mapa.crearCastilloSureste(jugadorB);
    }

    public void crearPlazas() throws casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, casilleroEstaOcupado, NoHaySuficienteOro
    //se crean en las otras dos esquinas
    {
        //Plaza central de jugadorA se crea en la esquina suroeste
        Casillero casilleroJugadorA = this.mapa.obtenerCasillero(this.mapa.obtenerTamanioFilas()-2,0);
        PlazaCentral plazaJugadorA = new PlazaCentral(casilleroJugadorA,this.mapa,jugadorA);
        plazaJugadorA.setearEstaConstruido(true);
        jugadorA.agregarPlazaCentral(plazaJugadorA);

        //Plaza central de jugadorB se crea en la esquina noreste
        Casillero casilleroJugadorB = this.mapa.obtenerCasillero(0,this.mapa.obtenerTamanioColumnas()-2);
        PlazaCentral plazaJugadorB = new PlazaCentral(casilleroJugadorB,this.mapa,jugadorB);
        plazaJugadorB.setearEstaConstruido(true);
        jugadorB.agregarPlazaCentral(plazaJugadorB);
        
        //Las plazas de cada jugador crean 3 aldeanos cada una
        for(int i=0;i<3;i++)
        {
            plazaJugadorA.crearAldeano();
            plazaJugadorA.settearPuntoRally(this.mapa);
            plazaJugadorB.crearAldeano();
            plazaJugadorB.settearPuntoRally(this.mapa);
        }
    }

    public GestorDeTurno obtenerGestorDeTurno() {
    	return this.gestor;
    }
    
    public void terminarTurno() throws HayUnGanador {
    	this.gestor.finalizarTurno();
    }
    
    public Jugador obtenerGanador(){
    	return (this.gestor.obtenerGanador());
    }

    public Mapa getMapa()
    {
        return this.mapa;
    }
    
    public Juego(Jugador jugadorA, Jugador jugadorB, int filas, int columnas) throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, casilleroEstaOcupado, NoHaySuficienteOro
    {
        this.jugadorA = jugadorA;
        this.jugadorB = jugadorB;
        jugadorA.setJuego(this);
        jugadorB.setJuego(this);
        this.mapa = new Mapa(filas,columnas);
        System.out.println("El problema no es la creacion del mapa");
        this.jugadorA.sumarOro(75);
        this.jugadorB.sumarOro(75);
        System.out.println("Suma bien los oros");
        this.crearCastillos();
        System.out.println("Crea bien los casitllos");
        this.crearPlazas();
        System.out.println("Crea bien las plazas");
        this.turno = 0;
        this.gestor= new GestorDeTurno(jugadorA, jugadorB, 1);
        System.out.println("Sale de la creacion del juego");
    }
}
