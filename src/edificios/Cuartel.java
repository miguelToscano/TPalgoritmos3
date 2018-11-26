package edificios;

import java.util.ArrayList;

import mapa.*;
import mapa.excepcionesMapa.*;
import unidades.*;
import jugador.*;

public class Cuartel extends Edificio
{

	private ArrayList<Militar> ejercito;
	
	
	public Cuartel(Caja lugarOcupado, Mapa mapa)
	{
		
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vida = 250;
		this.cajaOcupada = lugarOcupado;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa);
		ejercito = new ArrayList<Militar>();
	}

	public Cuartel(Caja lugarOcupado, Mapa mapa, Jugador jugador) {
		
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vida = 250;
		this.cajaOcupada = lugarOcupado;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa);
		this.jugador = jugador;
		ejercito = new ArrayList<Militar>();
	}
	
	public Cuartel() {
		
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vida = 250;
		ejercito = new ArrayList<Militar>();
	}
	
	public Cuartel(Casillero casilleroInicial, Mapa mapa, Jugador jugador) throws casilleroInvalido, cajaEstaOcupada
	{
		
		super(casilleroInicial, mapa);
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vida = 250;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa);
		this.jugador = jugador;
		
		ejercito = new ArrayList<Militar>();
		
	}

	public Cuartel(Casillero casilleroInicial, Mapa mapa) throws casilleroInvalido, cajaEstaOcupada
	{
		
		super(casilleroInicial, mapa);
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vida = 250;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa);
		
		ejercito = new ArrayList<Militar>();
		
	}
	
	public void crearEspadachin() throws casilleroEstaOcupado {
		
		Espadachin unEspadachin = new Espadachin(puntoRally);
		unEspadachin.setJugador(this.jugador);
		this.ejercito.add(unEspadachin);
		this.jugador.aumentarPoblacion(1);
	}
	
	public void crearArquero() throws casilleroEstaOcupado {
		
		Arquero unArquero = new Arquero(puntoRally);
		unArquero.setJugador(this.jugador);
		this.ejercito.add(unArquero);
		this.jugador.aumentarPoblacion(1);
	}
	
	//esto es un sida
	public boolean tieneEspadachin() {
		return this.ejercito.size() > 0;
	}
	
	public boolean tieneArquero() {
		return this.ejercito.size() > 0;
	}
	
	public void ubicar(Mapeable mapa)
    {
        return;
    }
}
