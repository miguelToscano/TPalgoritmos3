package edificios;

import java.util.ArrayList;

import mapa.excepcionesMapa.casilleroLleno;
import mapa.excepcionesMapa.casilleroInvalido;
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
	public PlazaCentral(Casillero casilleroInicial, Mapa mapa) throws casilleroInvalido
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
	
	public ArrayList<Aldeano> getAldeanos(){
		
		return aldeanos;
	}
	
	public void crearAldeano() throws casilleroLleno {
		
		Aldeano unAldeano = new Aldeano(puntoRally);
		// isRallyPoint ocupado? excepcion
		
		this.aldeanos.add(unAldeano);
	}
	
	
	public void ubicar(Mapeable mapa)
    {
        return;
    }
}
