package unidades;
import edificios.Edificio;
import unidades.Unidad;
import mapa.*;

public class Aldeano extends Unidad
{
	private boolean trabajando; // reparando/ construyendo, no recolecta oro

	//Constructores
	public Aldeano() {
		
	}
	
	//Coordenadas
	public Aldeano(int fila, int columna, Mapa mapa)
	{
		super(fila, columna, mapa);
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
	}
	
	//Casillero
	public Aldeano(Casillero casillero)
	{
		super(casillero);
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
	
	}
	

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
