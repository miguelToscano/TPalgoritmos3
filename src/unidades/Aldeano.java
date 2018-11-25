package unidades;
import edificios.Cuartel;
import edificios.Edificio;
import edificios.PlazaCentral;
import mapa.*;
import mapa.excepcionesMapa.casilleroEstaOcupado;

public class Aldeano extends Unidad
{
	public boolean trabajando; // reparando/ construyendo, no recolecta oro
	public Edificio edificioEnConstruccion=null;
	private int turnosConstruyendo=0;
	
    //Sin parametros
    public Aldeano()
    {
        this.costo = 25;
        this.trabajando = true;
        this.vida  =50;
    }

	//Coordenadas
	public Aldeano(int fila, int columna, Mapa mapa)throws casilleroEstaOcupado
	{
		super(fila, columna, mapa);
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
	}
	
	//Casillero
	public Aldeano(Casillero casillero) throws casilleroEstaOcupado
	{
		super(casillero);
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
	
	}
	

	public void construirPlazaCentral(Caja caja, Mapa mapa)
    {
		turnosConstruyendo++;
		trabajando=true;
		
		if (turnosConstruyendo==1) {
			PlazaCentral plaza = new PlazaCentral();
			edificioEnConstruccion=plaza;
		} else if (turnosConstruyendo==edificioEnConstruccion.getTurnosConstruccion()) {
			edificioEnConstruccion.mostrarConstruido();
			trabajando=false;
			turnosConstruyendo=0;
		}
		
	}
	
	public void construirCuartel(Caja caja, Mapa mapa)
    {
		turnosConstruyendo++;
		trabajando=true;
		
		if (turnosConstruyendo==1) {
			Cuartel plaza = new Cuartel(); // ?
			edificioEnConstruccion=plaza;
		} else if (turnosConstruyendo==edificioEnConstruccion.getTurnosConstruccion()) {
			edificioEnConstruccion.mostrarConstruido();
			trabajando=false;
			turnosConstruyendo=0;
		}
		
	}
//	public void construirEdificio(Edificio edificio, Casillero casillero, Mapa mapa)
//    {
//		edificio = new Edificio()
//	}
	
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

