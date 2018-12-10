package edificios;

import java.util.ArrayList;

import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.*;
import unidades.ArmaDeAsedio;
import unidades.Entidad;
import unidades.Unidad;
import juego.*;
import excepciones.superaLimitePoblacional;

public class Castillo extends Edificio
{
	private int radioAtaque;
	private int danioAEntidades;
	private Mapa mapa;

	private ArrayList<ArmaDeAsedio> armasDeAsedio;

	public Castillo (Caja lugarOcupado, Mapa mapa, Jugador jugador) throws cajaEstaOcupada

	{
		
		super(lugarOcupado,mapa,jugador);
		this.mapa = mapa;
		this.vidaCompleta= 1000;
		this.vida= this.vidaCompleta;
		this.construible = false;
		this.velocidadReparacion = 15;
		//this.cajaOcupada = lugarOcupado;
		this.radioAtaque = 3;
		this.danioAEntidades = 20;
		//this.cajaOcupada.llenar(this);
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
		// Obtener celdas circuncidantes
		// Si la instancia almacenada en cada celda es una unidad, atacarla
		
		for (int i = this.obtenerEspacioOcupado().obtenerPrimerCasillero().getFila() - this.radioAtaque; i < this.radioAtaque + 4; i++) {
			
			for (int j = this.obtenerEspacioOcupado().obtenerPrimerCasillero().getColumna() - this.radioAtaque; j < this.radioAtaque + 4; j++) {
				
				if ((i >= 0 && i <= 14) && (j >= 0 && j <= 14)) {
					
					Entidad entidadActual = this.mapa.obtenerCasillero(i, j).obtenerElemento();
					
					if (entidadActual instanceof Unidad && entidadActual.obtenerJugador() != this.obtenerJugador()) {
						
						entidadActual.recibirDanio(this.danioAEntidades, 0);
					}
				}
			}
		}
    }

    public Caja getCajaOcupada()
	{
		return this.cajaOcupada;
	}

	
}
