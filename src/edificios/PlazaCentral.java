package edificios;

import java.util.ArrayList;

import excepciones.CasilleroLleno;
import unidades.*;
import mapa.*;

public class PlazaCentral extends Edificio {

	private ArrayList<Aldeano> aldeanos;
	
	
	// constructores
	
	// le indico todos los casilleros que ocupa
	PlazaCentral(Caja lugarOcupado) {

		this.aldeanos = new ArrayList<Aldeano>();
		this.vida = 450;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 25;
		this.cajaOcupada = lugarOcupado;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally();
		
	}
	
	// indico el donde empieza
	PlazaCentral(Casillero casilleroInicial, Mapa mapa) throws casilleroInvalido
	{
		
		super(casilleroInicial, mapa);
		this.aldeanos = new ArrayList<Aldeano>();
		this.vida = 450;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 25;
		this.cajaOcupada.llenar(this);
		this.settearPuntoRally();
	}
	
	public ArrayList<Aldeano> getAldeanos(){
		
		return aldeanos;
	}
	
	public void crearAldeano() throws CasilleroLleno {
		
		Aldeano unAldeano = new Aldeano(puntoRally);
		// isRallyPoint ocupado? excepcion
		
		this.aldeanos.add(unAldeano);
	}
	
	
	public void ubicar(Mapeable mapa)
    {
        return;
    }
}
