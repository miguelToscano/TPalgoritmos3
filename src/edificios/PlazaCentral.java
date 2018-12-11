package edificios;

import java.util.ArrayList;

import excepciones.*;
import mapa.excepcionesMapa.*;
import unidades.*;
import mapa.*;
import juego.*;


public class PlazaCentral extends Edificio {

	private ArrayList<Aldeano> aldeanos;
	
	public int turnosConstruidos;
	
	// constructores
	
	// le indico todos los casilleros que ocupa
	public PlazaCentral(Caja lugarOcupado, Mapa mapa, Jugador jugador) throws cajaEstaOcupada
    {
        super(lugarOcupado,mapa,jugador);
		this.aldeanos = new ArrayList<Aldeano>();
		this.vidaCompleta = 450;
		this.vida=this.vidaCompleta;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.velocidadReparacion = 25;
		this.turnosConstruidos = 0;
		//this.cajaOcupada = lugarOcupado;
		//this.cajaOcupada.llenar(this);
	}
	
	public PlazaCentral() {
		super();
		this.aldeanos = new ArrayList<Aldeano>();
		this.vidaCompleta = 450;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.turnosConstruidos = 0;
		this.velocidadReparacion = 25;
	}

	@Override
	public void ejecutarLogicaDeTurno() {
		System.out.println("Soy una plaza central");
		
		if (this.turnosConstruidos < this.turnosConstruccion) {
			
			this.turnosConstruidos++;
			
			if (this.turnosConstruidos >= this.turnosConstruccion) {
				
				this.construido = true;
			}
		}
	}
	
	public void setearEstaConstruido(boolean valor) {
		this.construido = valor;
	}
	
	// indico el donde empieza
	public PlazaCentral(Casillero casilleroInicial, Mapa mapa, Jugador jugador) throws casilleroInvalido,
																	cajaEstaOcupada
	{
		super(casilleroInicial, mapa, jugador);
		this.aldeanos = new ArrayList<Aldeano>();
		this.vidaCompleta = 450;
		this.vida=this.vidaCompleta;
		this.costo = 100;
		this.turnosConstruccion = 3;
		this.turnosConstruidos = 0;
		this.velocidadReparacion = 25;
		//this.cajaOcupada.llenar(this);

	}


	public ArrayList<Aldeano> getAldeanos(){
		
		return aldeanos;
	}
	
	public void crearAldeano(Mapa mapa) throws casilleroEstaOcupado, SuperaLimitePoblacional, NoHaySuficienteOro {
		
		Aldeano aldeanoAuxiliar = new Aldeano();
		
		if (this.jugador.obtenerOro() < aldeanoAuxiliar.getCosto())
			throw new NoHaySuficienteOro();
		
		if (this.jugador.obtenerPoblacion() == 50) {
			throw new SuperaLimitePoblacional();
		}
		
		this.settearPuntoRally(mapa);
		
		Aldeano unAldeano = new Aldeano(this.puntoRally, jugador);
		this.aldeanos.add(unAldeano);
		this.jugador.cobrarOro(unAldeano.getCosto());
	}
	
	public void crearAldeano() throws casilleroEstaOcupado, SuperaLimitePoblacional, NoHaySuficienteOro
	{
		Aldeano aldeanoAuxiliar = new Aldeano();
		
		if (this.jugador.obtenerOro() < aldeanoAuxiliar.getCosto())
			throw new NoHaySuficienteOro();
		
		if (this.jugador.obtenerPoblacion() == 50) {
			throw new SuperaLimitePoblacional();
		}
		
		Aldeano unAldeano = new Aldeano(this.puntoRally, jugador);

		// isRallyPoint ocupado? excepcion
		this.jugador.cobrarOro(unAldeano.getCosto());
		this.aldeanos.add(unAldeano);
	}

}	
	
	
