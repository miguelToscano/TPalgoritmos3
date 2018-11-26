package edificios;

import java.util.ArrayList;

import excepciones.*;
import jugador.*;
import mapa.excepcionesMapa.*;
import unidades.*;
import mapa.*;


public class PlazaCentral extends Edificio {

	private ArrayList<Aldeano> aldeanos;
	
	
	// constructores
	
	// le indico todos los casilleros que ocupa
	public PlazaCentral(Caja lugarOcupado, Mapa mapa) {
	
		this.aldeanos = new ArrayList<Aldeano>();
		this.vida = 450;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 25;
		this.cajaOcupada = lugarOcupado;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa);
		
	}
	
	public PlazaCentral() {

		this.aldeanos = new ArrayList<Aldeano>();
		this.vida = 450;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 25;

	}
	
	// indico el donde empieza
	public PlazaCentral(Casillero casilleroInicial, Mapa mapa) throws casilleroInvalido, cajaEstaOcupada
	{
		
		super(casilleroInicial, mapa);
		this.aldeanos = new ArrayList<Aldeano>();
		this.vida = 450;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 25;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa);
	}
	
	public PlazaCentral(Casillero casillero, Mapa mapa, Jugador jugador) throws casilleroInvalido, cajaEstaOcupada {
		
		super(casillero, mapa);
		this.aldeanos = new ArrayList<Aldeano>();
		this.vida = 450;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 25;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally(mapa);
		this.jugador = jugador;
	}

	public ArrayList<Aldeano> getAldeanos(){
		
		return aldeanos;
	}
	
	public void crearAldeano() throws casilleroEstaOcupado, SuperaLimitePoblacional
	{
		
		Aldeano unAldeano = new Aldeano(puntoRally);
		// isRallyPoint ocupado? excepcion
		
		this.aldeanos.add(unAldeano);
		unAldeano.setJugador(this.jugador);
		this.jugador.aumentarPoblacion(1);
	}
	
	
	public void ubicar(Mapeable mapa)
    {
        return;
    }
}
