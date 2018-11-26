package edificios;

import java.util.ArrayList;

import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.*;
import unidades.ArmaDeAsedio;
import jugador.*;
public class Castillo extends Edificio
{
	private int radioAtaque;
	private int danioAEntidades;
	
	ArrayList<ArmaDeAsedio> armasDeAsedio;
	
	Castillo (Caja lugarOcupado, Mapa mapa)
	{
		
		this.vida= 1000;
		this.construible = false;
		this.velocidadReparacion = 15;
		this.cajaOcupada = lugarOcupado;
		this.radioAtaque = 3;
		this.danioAEntidades = 20;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa); // ojo que aca puede estar en el medio

		this.armasDeAsedio = new ArrayList<ArmaDeAsedio>();
	}

	Castillo (Caja lugarOcupado, Mapa mapa, Jugador jugador)
	{		
		this.vida= 1000;
		this.construible = false;
		this.velocidadReparacion = 15;
		this.cajaOcupada = lugarOcupado;
		this.radioAtaque = 3;
		this.danioAEntidades = 20;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa); // ojo que aca puede estar en el medio
		this.jugador = jugador;
		this.armasDeAsedio = new ArrayList<ArmaDeAsedio>();
	}

	
	public void crearArmaDeAsedio() throws casilleroEstaOcupado
    {
		//check posicion esta en espacioOcupado
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(puntoRally);
		
		armasDeAsedio.add(unArmaDeAsedio);
	}
	
	public boolean tieneArmaDeAsedio()
	{
		return !this.armasDeAsedio.isEmpty();
	}
	
	public void atacarCircundantes()
    {
		
    }
	

	public void ubicarEn(Mapeable mapeable)
	{
		this.cajaOcupada = (Caja)mapeable;
	}

	
}