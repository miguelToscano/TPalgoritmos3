package unidades;
import edificios.Edificio;
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
	public Aldeano(int fila, int columna, Mapa mapa)
	{
		super(fila, columna, mapa);
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
		mapa.cambiarContenidoDeCasillero(fila,columna,this);
	}
	
	//Casillero
	public Aldeano(Casillero casillero)
	{
		super(casillero);
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
		casillero.cambiarContenido(this);
	
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
