package edificios;

import java.util.ArrayList;

import excepciones.NoHaySuficienteOro;
import excepciones.SuperaLimitePoblacional;
import mapa.*;
import mapa.excepcionesMapa.*;
import unidades.*;
import juego.*;

public class Cuartel extends Edificio
{

	private ArrayList<Militar> ejercito;
    private ArrayList<ArmaDeAsedio> armas;
    private ArrayList<Arquero> arqueros= new ArrayList<Arquero>();
    private ArrayList<Espadachin> espadachines = new ArrayList<Espadachin>();

	int turnosConstruidos;
	
	public Cuartel(Caja lugarOcupado, Mapa mapa, Jugador jugador) throws cajaEstaOcupada	{
		super(lugarOcupado,mapa,jugador);
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vidaCompleta = 250;
		this.vida=this.vidaCompleta;
		this.turnosConstruidos = 0;
		//this.cajaOcupada = lugarOcupado;
		//this.cajaOcupada.llenar(this);
		ejercito = new ArrayList<Militar>();
	    this.armas = new ArrayList<ArmaDeAsedio>();
	    this.arqueros = new ArrayList<Arquero>();
	    this.espadachines = new ArrayList<Espadachin>();
	}
	
	public Cuartel() {
		super();
		this.turnosConstruccion = 3;
		this.turnosConstruidos = 0;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vidaCompleta = 250;
		//this.cajaOcupada = lugarOcupado;
		//this.cajaOcupada.llenar(this);
		ejercito = new ArrayList<Militar>();
	    this.armas = new ArrayList<ArmaDeAsedio>();
	    this.arqueros = new ArrayList<Arquero>();
	    this.espadachines = new ArrayList<Espadachin>();
	}

	@Override
	public void ejecutarLogicaDeTurno() {
		System.out.println("Soy un Cuartel");
		
		if (this.turnosConstruidos < this.turnosConstruccion) {
			
			this.turnosConstruidos++;
			
			if (this.turnosConstruidos == this.turnosConstruccion) {
				
				this.construido = true;
			}
		}
	}
	
	public Cuartel(Casillero casilleroInicial, Mapa mapa, Jugador jugador) throws casilleroInvalido, cajaEstaOcupada,
            SuperaLimitePoblacional
	{
		
		super(casilleroInicial, mapa, jugador);
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vidaCompleta = 250;
		this.vida=this.vidaCompleta;
		//this.cajaOcupada.llenar(this);
		//this.settearPuntoRally(mapa);
		this.jugador = jugador;
		this.turnosConstruidos = 0;
		ejercito = new ArrayList<Militar>();
		
	}

	
	public void crearEspadachin() throws casilleroEstaOcupado, SuperaLimitePoblacional, NoHaySuficienteOro {
		Espadachin espadachinAuxiliar = new Espadachin();
		
		if (this.jugador.obtenerOro() < espadachinAuxiliar.getCosto())
			throw new NoHaySuficienteOro();
		
		if (this.jugador.obtenerPoblacion() == 50)
			throw new SuperaLimitePoblacional();
		
		Espadachin unEspadachin = new Espadachin(puntoRally,this.jugador);
		this.espadachines.add(unEspadachin);
		this.jugador.cobrarOro(unEspadachin.getCosto());
		this.jugador.aumentarPoblacion(1);
	}

	public void crearEspadachin(Mapa mapa) throws casilleroEstaOcupado, SuperaLimitePoblacional, NoHaySuficienteOro {
		
		Espadachin espadachinAuxiliar = new Espadachin();
		
		if (this.jugador.obtenerOro() < espadachinAuxiliar.getCosto())
			throw new NoHaySuficienteOro();
		
		if (this.jugador.obtenerPoblacion() == 50) {
			throw new SuperaLimitePoblacional();
		}
		
		this.settearPuntoRally(mapa);
		Espadachin unEspadachin = new Espadachin(puntoRally,this.jugador);
		this.espadachines.add(unEspadachin);
		this.jugador.cobrarOro(unEspadachin.getCosto());
		this.jugador.aumentarPoblacion(1);
	}

	
	public void crearArquero() throws casilleroEstaOcupado, SuperaLimitePoblacional, NoHaySuficienteOro {
		
		Arquero arqueroAuxiliar = new Arquero();
		
		if (this.jugador.obtenerOro() < arqueroAuxiliar.getCosto())
			throw new NoHaySuficienteOro();

		if (this.jugador.obtenerPoblacion() == 50) {
			throw new SuperaLimitePoblacional();
		}
		
		Arquero unArquero = new Arquero(puntoRally,this.jugador);
		this.arqueros.add(unArquero);
		this.jugador.cobrarOro(unArquero.getCosto());
		this.jugador.aumentarPoblacion(1);
	}
	
	public void crearArquero(Mapa mapa) throws casilleroEstaOcupado, SuperaLimitePoblacional, NoHaySuficienteOro {
		
		Arquero arqueroAuxiliar = new Arquero();
		
		if (this.jugador.obtenerOro() < arqueroAuxiliar.getCosto())
			throw new NoHaySuficienteOro();
		
		if (this.jugador.obtenerPoblacion() == 50) {
			throw new SuperaLimitePoblacional();
		}
		
		this.settearPuntoRally(mapa);
		
		Arquero unArquero = new Arquero(puntoRally,this.jugador);
		this.arqueros.add(unArquero);
		this.jugador.cobrarOro(unArquero.getCosto());
		this.jugador.aumentarPoblacion(1);
	}
	
    public boolean tieneArquero() {
		return this.arqueros.size() > 0;
	}
  
  	public boolean tieneEspadachin() {
  		return this.espadachines.size() > 0;
  	}
}

