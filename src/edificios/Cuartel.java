package edificios;

import java.util.ArrayList;

import mapa.*;
import unidades.*;

public class Cuartel extends Edificio {

	private ArrayList<Militar> ejercito;
	
	
	Cuartel(Caja lugarOcupado) {
		
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vida = 250;
		this.cajaOcupada = lugarOcupado;
		this.settearPuntoRally();
		ejercito = new ArrayList<Militar>();
	}
	
	Cuartel(Casillero casilleroInicial, Mapa mapa) throws casilleroInvalido
	{
		
		super(casilleroInicial, mapa);
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 50;
		this.costo = 50;
		this.vida = 250;
		this.settearPuntoRally();
		ejercito = new ArrayList<Militar>();
		
	}
	
	public void crearEspadachin() {
		
		Espadachin unEspadachin = new Espadachin(puntoRally);
		
		this.ejercito.add(unEspadachin);
	}
	
	public void crearArquero() {
		
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