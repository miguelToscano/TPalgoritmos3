package unidades;
import edificios.Cuartel;
import edificios.Edificio;
import edificios.PlazaCentral;
import excepciones.superaLimitePoblacional;
import mapa.*;
import mapa.excepcionesMapa.*;
import juego.*;

public class Aldeano extends Unidad
{
	public boolean trabajando; // reparando/ construyendo, no recolecta oro
	private Edificio edificioEnConstruccion=null;
	private int turnosConstruyendo=0;
	
	final static int ORO_POR_TURNO = 25;
	
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

	public Aldeano(int fila, int columna, Mapa mapa, Jugador jugador)throws casilleroEstaOcupado, superaLimitePoblacional
	{
		super(fila, columna, mapa);
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
		this.jugador = jugador;
		this.jugador.aumentarPoblacion(1);
	}
	
	//Casillero
	public Aldeano(Casillero casillero) throws casilleroEstaOcupado
	{
		super(casillero);
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
	
	}
	//Casillero y jugador
	public Aldeano(Casillero casillero, Jugador jugador) throws casilleroEstaOcupado, superaLimitePoblacional
	{
			super(casillero);
			this.costo = 25;
			this.trabajando = false;
			this.vida = 50;
			this.jugador = jugador;
			this.jugador.aumentarPoblacion(1);
		
	}
	public void construirPlazaCentral(Caja caja, Mapa mapa,Jugador jugador) throws cajaEstaOcupada, superaLimitePoblacional

    {
		turnosConstruyendo++;
		trabajando=true;
		
		if (turnosConstruyendo==1)
		{
			PlazaCentral plaza = new PlazaCentral(caja,mapa,jugador);
			edificioEnConstruccion=plaza;
		} else if (turnosConstruyendo==edificioEnConstruccion.getTurnosConstruccion())
		{
			edificioEnConstruccion.mostrarConstruido();
			trabajando=false;
			turnosConstruyendo=0;
		}
		
	}
	
	public void construirCuartel(Caja caja, Mapa mapa,Jugador jugador) throws cajaEstaOcupada,superaLimitePoblacional
    {
		turnosConstruyendo++;
		trabajando=true;
		
		if (turnosConstruyendo==1)
		{
			Cuartel plaza = new Cuartel(caja,mapa,jugador); // ?
			edificioEnConstruccion=plaza;
		}
		else if (turnosConstruyendo==edificioEnConstruccion.getTurnosConstruccion())
		{
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
	public void matar() {
		this.trabajando = false;
		this.vida = 0;
		this.jugador.reducirPoblacion(1);
	}
	
//	public int recolectarOro ()
//    {
//		if	(trabajando)
//		{
//			return 0;
//		}
//		else
//		    {
//			return 20;
//		}
//	}
	
	public void recolectarOro() {
		
		if (!trabajando && this.estaVivo()) {
			this.jugador.sumarOro(ORO_POR_TURNO);
		}
	}
	
	public Edificio obtenerEdificioEnConstruccion() {
		
			return this.edificioEnConstruccion;
		
	}
}

