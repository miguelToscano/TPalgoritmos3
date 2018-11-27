package edificios;

import java.util.ArrayList;

import excepciones.superaLimitePoblacional;
import mapa.*;
import mapa.excepcionesMapa.*;
import unidades.*;
import juego.*;

public class Cuartel extends Edificio
{

	private ArrayList<Militar> ejercito;
	
	
	public Cuartel(Caja lugarOcupado, Mapa mapa, Jugador jugador) throws cajaEstaOcupada,superaLimitePoblacional
	{
		super(lugarOcupado,mapa,jugador);
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vidaCompleta = 250;
		this.vida=this.vidaCompleta;
		this.cajaOcupada = lugarOcupado;
		this.cajaOcupada.llenar(this);
		ejercito = new ArrayList<Militar>();
	}

	
	public Cuartel(Casillero casilleroInicial, Mapa mapa, Jugador jugador) throws casilleroInvalido, cajaEstaOcupada,
																					superaLimitePoblacional
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

	
	public void crearEspadachin() throws casilleroEstaOcupado, superaLimitePoblacional {
		
		Espadachin unEspadachin = new Espadachin(puntoRally,this.jugador);
		this.ejercito.add(unEspadachin);
	}
	
	public void crearArquero() throws casilleroEstaOcupado, superaLimitePoblacional {
		
		Arquero unArquero = new Arquero(puntoRally,this.jugador);
		this.ejercito.add(unArquero);
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

