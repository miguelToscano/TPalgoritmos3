package edificios;

import java.util.ArrayList;

import unidades.ArmaDeAsedio;

import mapa.*;


public class Castillo extends Edificio
{
	
	ArrayList<ArmaDeAsedio> armasDeAsedio;
	
	Castillo (Caja cajaOcupada)
	{
		this.vida= 1000;
		this.construible = false;
		this.velocidadReparacion = 15;
		this.cajaOcupada = cajaOcupada;

		armasDeAsedio = new ArrayList<ArmaDeAsedio>();
	}
	
	public void crearArmaDeAsedio(int fila, int columna, Mapa mapa)
    {
		if(mapa.obtenerCasillero(fila,columna).estaLibre())
		{
			ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(fila,columna,mapa);
			armasDeAsedio.add(unArmaDeAsedio);
		}

		//else excepcion

	}
	
	public boolean tieneArmaDeAsedio() {
		return !this.armasDeAsedio.isEmpty();
	}
	
	public void atacarCircundantes()
    {
		int radioAtaque = 3;
		// atacar
		
	}

	public void ubicar(Mapeable mapeable)
	{
		this.cajaOcupada = (Caja)mapeable;
	}

	public Caja obtenerEspacioOcupado()
	{
		return this.cajaOcupada;
	}
}