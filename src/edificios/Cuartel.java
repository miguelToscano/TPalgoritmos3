package edificios;

import java.util.ArrayList;

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

	
	
	public Cuartel(Caja lugarOcupado, Mapa mapa, Jugador jugador) throws cajaEstaOcupada	{
		super(lugarOcupado,mapa,jugador);
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vidaCompleta = 250;
		this.vida=this.vidaCompleta;
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
		
		ejercito = new ArrayList<Militar>();
		
	}

	
	public void crearEspadachin() throws casilleroEstaOcupado, SuperaLimitePoblacional {
		
		Espadachin unEspadachin = new Espadachin(puntoRally,this.jugador);
		this.espadachines.add(unEspadachin);
	}

	public void crearEspadachin(Mapa mapa) throws casilleroEstaOcupado, SuperaLimitePoblacional {
		
		this.settearPuntoRally(mapa);
		Espadachin unEspadachin = new Espadachin(puntoRally,this.jugador);
		this.espadachines.add(unEspadachin);
	}

	
	public void crearArquero() throws casilleroEstaOcupado, SuperaLimitePoblacional {
		
		Arquero unArquero = new Arquero(puntoRally,this.jugador);
		this.arqueros.add(unArquero);
	}
	
	public void crearArquero(Mapa mapa) throws casilleroEstaOcupado, SuperaLimitePoblacional {
		
		this.settearPuntoRally(mapa);
		
		Arquero unArquero = new Arquero(puntoRally,this.jugador);
		this.arqueros.add(unArquero);
	}
	
    public boolean tieneArquero() {
		return this.arqueros.size() > 0;
	}
    
  
  	public boolean tieneEspadachin() {
  		return this.espadachines.size() > 0;
  	}
	
	
	
	
}

