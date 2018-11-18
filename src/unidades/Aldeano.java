package unidades;
import edificios.Edificio;

public class Aldeano extends Unidad
{
	private boolean trabajando; // reparando/ construyendo, no recolecta oro

	public Aldeano()
	{
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
	}

	//public Aldeano(int [] posicion)
	//{
		
	//this.espacioOcupado = posicion;
	
	//}

	public void construirEdificio()
    {
		System.out.println("Construye un edificio");
	}
	
	public void repararEdificio(Edificio unEdificio)
    {
		unEdificio.reparar();
		trabajando = true;
		
	}
	
	//public Edificio construirEdificio ()
	
	
	public int recolectarOro ()
    {
		if	(trabajando)
		{
			return 0;
		}
		else
		    {
			return 20;
		}
	}
}
