package edificios;

import java.util.ArrayList;

import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.*;
import unidades.ArmaDeAsedio;
import juego.*;
import excepciones.superaLimitePoblacional;

public class Castillo extends Edificio
{
	private int radioAtaque;
	private int danioAEntidades;

	private ArrayList<ArmaDeAsedio> armasDeAsedio;

	public Castillo (Caja lugarOcupado, Mapa mapa, Jugador jugador) throws cajaEstaOcupada, superaLimitePoblacional

	{
		super(lugarOcupado,mapa,jugador);
		this.vidaCompleta= 1000;
		this.vida= this.vidaCompleta;
		this.construible = false;
		this.velocidadReparacion = 15;
		this.cajaOcupada = lugarOcupado;
		this.radioAtaque = 3;
		this.danioAEntidades = 20;
		this.cajaOcupada.llenar(this);
		this.armasDeAsedio = new ArrayList<ArmaDeAsedio>();

	}

	public void crearArmaDeAsedio() throws casilleroEstaOcupado,superaLimitePoblacional
    {
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(puntoRally,this.jugador);
		this.armasDeAsedio.add(unArmaDeAsedio);
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
