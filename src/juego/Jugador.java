package juego;
import edificios.*;
import excepciones.SuperaLimitePoblacional;
import unidades.*;
import java.util.ArrayList;

//Cada jugador comienza con una plaza central y un castillo. No es posible construir un castillo. SÃƒÆ’Ã‚Â³lo
// existirÃƒÆ’Ã‚Â¡ el que es asignado al empezar la partida. SÃƒÆ’Ã‚Â­ es posible construir plazas centrales y cuarteles sin lÃƒÆ’Ã‚Â­mite.
//
//Cada jugador comienza la partida con 3 aldeanos y 100 de oro
//
//Los jugadores inician en extremos opuestos del mapa.
//
//El lÃƒÆ’Ã‚Â­mite de poblaciÃƒÆ’Ã‚Â³n es 50 (para cada jugador, es decir, 100 en total). Cada unidad del jugador ocupa 1 lugar de poblaciÃƒÆ’Ã‚Â³n. Los edificios no ocupan lugar de poblaciÃƒÆ’Ã‚Â³n.


public class Jugador
{
	private String nombre;
    private Castillo castillo;
    private ArrayList<PlazaCentral> plazas = new ArrayList<PlazaCentral>();
    private ArrayList<Cuartel> cuarteles = new ArrayList<Cuartel>();
    private ArrayList<Aldeano> aldeanos =  new ArrayList<Aldeano>();
    private boolean habilitado=false;
    private Juego juego;
    
    final static int ORO_INICIAL = 100;
    final static int LIMITE_POBLACION = 50;
    
    protected int oro;
    protected int poblacion;

    public Jugador() {

        this.oro = ORO_INICIAL;
        this.poblacion = 3;
        this.habilitado=false;

    }
    
    public void setJuego(Juego juego) {
		this.juego = juego;
	}

    public void asignarCastillo(Castillo castillo)
    {
        this.castillo = castillo;
    }

    public Castillo getCastillo()
    {
        return this.castillo;
    }
    
    public ArrayList<Cuartel> getCuarteles()
    {
        return this.cuarteles;
    }
    

    public void agregarPlazaCentral(PlazaCentral plaza)
    {
        this.plazas.add(plaza);
    }
    
    public void agregarCuartel(Cuartel cuartel)
    {
        this.cuarteles.add(cuartel);
    }

    public int obtenerPoblacion() {

        return this.poblacion;
    }

    // Esta funcion es solo para usarla en los Test
    public void establecerPoblacion(int nuevaPoblacion) {

        this.poblacion = nuevaPoblacion;
    }

    public void cobrarOro(int oro) {
    	if (oro <= this.oro) {
    		this.oro -= oro;
    	}
    }
    
    public ArrayList<PlazaCentral> getPlazas()
    {
        return this.plazas;
    }

    public void aumentarPoblacion(int cantidad) throws SuperaLimitePoblacional {

        if (this.poblacion + cantidad > LIMITE_POBLACION)
            throw new SuperaLimitePoblacional();

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
    
    public void deshabilitar()
    {
    	this.habilitado=false;
    }
    
    public boolean esTuTurno()
    {
    	return (this.habilitado);
    }
    
    public boolean perdioLaPartida()
    {
    	return (this.getCastillo().destruidoTotalmente());
    }

    //para las pruebas
    public int cantidadDeAldeanos()
    {
        return this.aldeanos.size();
    }

    public void agregarAldeano(Aldeano aldeano)
    {
        this.aldeanos.add(aldeano);
    }
    
    public boolean tieneArquero() {
    	boolean tiene=false;
    	for (Cuartel c: this.cuarteles) {
    		if (c.tieneArquero()) {
    			tiene=true;
    			break;
    		}
    	}
    	return tiene;
	}
    
  
  	public boolean tieneEspadachin() {
  		boolean tiene=false;
    	for (Cuartel c: this.cuarteles) {
    		if (c.tieneEspadachin()) {
    			tiene=true;
    			break;
    		}
    	}
    	return tiene;
  	}

    public Jugador(String nombre) {

    	this.nombre = nombre;
        this.oro = ORO_INICIAL;
        this.poblacion = 3;
        this.habilitado=false;
    }
    
    public String obtenerNombre() {
    	return this.nombre;
    }
}
