package unidades;
import edificios.Edificio;
import edificios.PlazaCentral;

public class Aldeano extends Unidad {

	
	protected int costo = 25;
	public boolean trabajando = false; // reparando/ construyendo, no recolecta oro
	private int turnosConstruyendo = 0;
	public Edificio edificioEnConstruccion = null;
	
	public Aldeano()
	{
		
	}

	//public Aldeano(int [] posicion)
	//{
		
	//this.espacioOcupado = posicion;
	
	//}

	public void construirPlaza() {
		
		turnosConstruyendo++;
		trabajando=true;
		
		
		if (turnosConstruyendo==1) {
			PlazaCentral plaza = new PlazaCentral();
			edificioEnConstruccion=plaza;
			
		} else if(turnosConstruyendo==edificioEnConstruccion.turnosConstruccion){
			
			terminarConstruccion();
		}
	
	}
	
	private void terminarConstruccion() {

		//edificioEnConstruccion.jugador=this.jugador;
		edificioEnConstruccion=null;
		trabajando=false;
		turnosConstruyendo=0;
	}
	
	public void repararEdificio(Edificio unEdificio) {
		
		unEdificio.reparar();
		trabajando = true;
		
		
	}
	
	public int sumarOro () {
		if	(trabajando) {
			return 0;
		}
		else {
			return 20;
		}
	}
}
