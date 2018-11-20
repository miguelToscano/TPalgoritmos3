package unidades;
import edificios.Edificio;
import excepciones.*;
import mapa.*;

public class Aldeano extends Unidad
{
	private boolean trabajando; // reparando/ construyendo, no recolecta oro

    //Sin parametros
    public Aldeano()
    {
        this.costo = 25;
        this.trabajando = true;
        this.vida  =50;
    }

	//Coordenadas
	public Aldeano(int fila, int columna, Mapa mapa)throws CasilleroLleno
	{
		super(fila, columna, mapa);
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
	}
	
	//Casillero
	public Aldeano(Casillero casillero) throws CasilleroLleno
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
