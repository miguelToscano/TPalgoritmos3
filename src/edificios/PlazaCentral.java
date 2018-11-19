package edificios;

import java.util.ArrayList;
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
		this.settearPuntoRally();
		
	}
	
	// indico el donde empieza
	PlazaCentral(Casillero casilleroInicial, Mapa mapa) {
		
		super(casilleroInicial, mapa);
		this.aldeanos = new ArrayList<Aldeano>();
		this.vida = 450;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 25;
		this.settearPuntoRally();
		
		
	}
	
	public ArrayList<Aldeano> getAldeanos(){
		
		return aldeanos;
	}
	
	public void crearAldeano() {
		
		Aldeano unAldeano = new Aldeano(puntoRally);
		// isRallyPoint ocupado? excepcion
		
		this.aldeanos.add(unAldeano);
	}
	
	// Funcion solo para que pase las pruebas
	public boolean tieneAldeano() {
		return this.aldeanos.size() > 0;
	}

	public void ubicar(Mapeable mapa)
    {
        return;
    }
}
