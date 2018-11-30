package juego;
import edificios.*;
import excepciones.superaLimitePoblacional;
import unidades.*;
import java.util.ArrayList;

//Cada jugador comienza con una plaza central y un castillo. No es posible construir un castillo. SÃƒÂ³lo
// existirÃƒÂ¡ el que es asignado al empezar la partida. SÃƒÂ­ es posible construir plazas centrales y cuarteles sin lÃƒÂ­mite.
//
//Cada jugador comienza la partida con 3 aldeanos y 100 de oro
//
//Los jugadores inician en extremos opuestos del mapa.
//
//El lÃƒÂ­mite de poblaciÃƒÂ³n es 50 (para cada jugador, es decir, 100 en total). Cada unidad del jugador ocupa 1 lugar de poblaciÃƒÂ³n. Los edificios no ocupan lugar de poblaciÃƒÂ³n.

// por que mierda tiene un atributo jeugo? doble flecha

public class Jugador
{
    private Castillo castillo;
    private ArrayList<PlazaCentral> plazas = new ArrayList<PlazaCentral>();
    private ArrayList<Cuartel> cuarteles = new ArrayList<Cuartel>();
    private ArrayList<Aldeano> aldeanos =  new ArrayList<Aldeano>();
    private ArrayList<ArmaDeAsedio> armas = new ArrayList<ArmaDeAsedio>();
    private ArrayList<Arquero> arqueros = new ArrayList<Arquero>();
    private ArrayList<Espadachin> espadachines = new ArrayList<Espadachin>();
     
    private boolean habilitado;
    private Juego juego=null;
    
    final static int ORO_INICIAL = 100;
    final static int LIMITE_POBLACION = 50;
    
    protected int oro;
    protected int poblacion;

    public Jugador() {

        this.oro = ORO_INICIAL;
        this.poblacion = 0;
        this.habilitado=false;

    }
    
    public Jugador(Juego juego) {

        this.oro = ORO_INICIAL;
        this.poblacion = 0;
        this.habilitado=false;
        this.juego=juego;

    }

    public void asignarCastillo(Castillo castillo)
    {
        this.castillo = castillo;
    }

    public Castillo getCastillo()
    {
        return this.castillo;
    }

    public void agregarPlazaCentral(PlazaCentral plaza)
    {
        plazas.add(plaza);
    }


    public int obtenerPoblacion() {

        return this.poblacion;
    }

    // Esta funcion es solo para usarla en los Test
    public void establecerPoblacion(int nuevaPoblacion) {

        this.poblacion = nuevaPoblacion;
    }


    public ArrayList<PlazaCentral> getPlazas()
    {
        return this.plazas;
    }

    public void aumentarPoblacion(int cantidad) throws superaLimitePoblacional {

        if (this.poblacion + cantidad > LIMITE_POBLACION)
            throw new superaLimitePoblacional();

        this.poblacion += cantidad;
    }

    public void reducirPoblacion(int cantidad) {

        this.poblacion -= cantidad;
    }

    public int obtenerOro() {

        return this.oro;
    }

    public void sumarOro(int oro) {
        this.oro += oro;
    }
    
    public void habilitar() {
    	this.habilitado=true;
    }
    
    public void deshabilitar() {
    	this.habilitado=false;
    }
    
    public boolean esTuTurno() {
    	return (this.habilitado);
    }
    
    public void terminarJugada() {
    	this.habilitarPiezas();
    	juego.terminarTurno();
    }
    
    public boolean perdioLaPartida() {
    	return (this.getCastillo().destruidoTotalmente());
    }
    
    public void habilitarPiezas() {
    	
    	for (Unidad u: aldeanos) {
    		u.habilitar();
    	}
    	for (Unidad u: espadachines) {
    		u.habilitar();
    	}
    	for (Unidad u: arqueros) {
    		u.habilitar();
    	}
    	for (Unidad u: armas) {
    		u.habilitar();
    	}
    }

}
