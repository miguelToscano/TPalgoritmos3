package edificios;

import java.util.ArrayList;

import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.*;
import unidades.ArmaDeAsedio;
import jugador.*;

public class Castillo extends Edificio
{
	private Jugador duenio;
	private int radioAtaque;
	private int danioAEntidades;
	
	private ArrayList<ArmaDeAsedio> armasDeAsedio;
	
	public Castillo (Caja lugarOcupado, Mapa mapa, Jugador jugador)
	{
		this.duenio = jugador;
		this.vida= 1000;
		this.construible = false;
		this.velocidadReparacion = 15;
		this.cajaOcupada = lugarOcupado;
		this.radioAtaque = 3;
		this.danioAEntidades = 20;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa); // ojo que aca puede estar en el medio
		this.armasDeAsedio = new ArrayList<ArmaDeAsedio>();
		this.ubicarEn(lugarOcupado);
	}
	
	public void crearArmaDeAsedio() throws casilleroEstaOcupado
    {
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(puntoRally);
		this. armasDeAsedio.add(unArmaDeAsedio);
	}
	
	public boolean tieneArmaDeAsedio()
	{
		return !this.armasDeAsedio.isEmpty();
	}
	
	public void atacarCircundantes()
    {
		
    }

    public Caja getCajaOcupada()
	{
		return this.cajaOcupada;
	}


	public void ubicarEn(Mapeable mapeable)
	{
		Caja caja = (Caja)mapeable;
		this.cajaOcupada = caja;
		caja.llenar(this);
	}
	
}