package edificios;

import java.util.ArrayList;

import mapa.excepcionesMapa.casilleroLleno;
import mapa.*;
import mapa.excepcionesMapa.casilleroInvalido;
import unidades.*;

public class Cuartel extends Edificio {

	private ArrayList<Militar> ejercito;
	
	
	public Cuartel(Caja lugarOcupado, Mapa mapa) {
		
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vida = 250;
		this.cajaOcupada = lugarOcupado;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa);
		ejercito = new ArrayList<Militar>();
	}
	
	public Cuartel() {
		
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vida = 250;
		ejercito = new ArrayList<Militar>();
	}
	
	public Cuartel(Casillero casilleroInicial, Mapa mapa) throws casilleroInvalido
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
	
	public void crearEspadachin() throws casilleroLleno {
		
		Espadachin unEspadachin = new Espadachin(puntoRally);
		
		this.ejercito.add(unEspadachin);
	}
	
	public void crearArquero() throws casilleroLleno {
		
		Arquero unArquero = new Arquero(puntoRally);
		
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
