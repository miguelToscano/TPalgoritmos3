package edificios;

import java.util.ArrayList;

import excepciones.CasilleroLleno;
import mapa.*;
import unidades.ArmaDeAsedio;

public class Castillo extends Edificio
{
	private int radioAtaque;
	private int danioAEntidades;
	
	ArrayList<ArmaDeAsedio> armasDeAsedio;
	
	Castillo (Caja lugarOcupado)
	{
		
		this.vida= 1000;
		this.construible = false;
		this.velocidadReparacion = 15;
		this.cajaOcupada = lugarOcupado;
		this.radioAtaque = 3;
		this.danioAEntidades = 20;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(); // ojo que aca puede estar en el medio

		this.armasDeAsedio = new ArrayList<ArmaDeAsedio>();
	}
	
	public void crearArmaDeAsedio() throws CasilleroLleno
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
	

	public void ubicar(Mapeable mapeable)
	{
		this.cajaOcupada = (Caja)mapeable;
	}

	
}