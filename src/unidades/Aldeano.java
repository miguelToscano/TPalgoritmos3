package unidades;
import edificios.Edificio;

public class Aldeano extends Unidad {

	
	protected int costo = 25;
	private boolean trabajando = false; // reparando/ construyendo, no recolecta oro

	public Aldeano()
	{

	}

	//public Aldeano(int [] posicion)
	//{
		
	//this.espacioOcupado = posicion;
	
	//}

	public void construirEdificio() {
		System.out.println("Construye un edificio");
	}
	
	public void repararEdificio(Edificio unEdificio) {
		
		unEdificio.reparar();
		trabajando = true;
		
		
	}
	
	//public Edificio construirEdificio ()
	
	
	public int sumarOro () {
		if	(trabajando) {
			return 0;
		}
		else {
			return 20;
		}
	}
}
