package unidades;
import edificios.Cuartel;
import edificios.Edificio;
import edificios.PlazaCentral;
import excepciones.*;
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
//	public Aldeano(int fila, int columna, Mapa mapa)throws casilleroEstaOcupado
//	{
//		super(fila, columna, mapa);
//		this.costo = 25;
//		this.trabajando = false;
//		this.vida = 50;
//	}

	public Aldeano(int fila, int columna, Mapa mapa, Jugador jugador)throws casilleroEstaOcupado, SuperaLimitePoblacional
	{
		super(fila, columna, mapa);
		this.costo = 25;
		this.trabajando = false;
		this.vida = 50;
		this.jugador = jugador;
		this.jugador.aumentarPoblacion(1);
	}
	
	@Override
	public void ejecutarLogicaDeTurno() {
		if (!this.trabajando)
			this.jugador.sumarOro(25);
		System.out.println("Soy un aldeano");
	}
	
	//Casillero
//	public Aldeano(Casillero casillero) throws casilleroEstaOcupado
//	{
//		super(casillero);
//		this.costo = 25;
//		this.trabajando = false;
//		this.vida = 50;
//	
//	}
	//Casillero y jugador
	public Aldeano(Casillero casillero, Jugador jugador) throws casilleroEstaOcupado, SuperaLimitePoblacional
	{
			super(casillero,jugador);
			this.costo = 25;
			this.trabajando = false;
			this.vida = 50;
			this.jugador = jugador;
//			this.jugador.aumentarPoblacion(1);
			this.jugador.agregarAldeano(this);
		
	}
	public void construirPlazaCentral(Casillero casillero, Mapa mapa,Jugador jugador) throws CajaNoEstaPegadaAAldeano, cajaEstaOcupada, casilleroInvalido, PiezaDeshabilitadaEnTurno

    {
    	Caja caja = mapa.asignarCajaACasillero(casillero);
    	boolean cajaPegadaAAldeano=false;
    	for(int i=0;i<mapa.obtenerCasillerosCircundantes(caja).size();i++)
		{
			if(mapa.obtenerCasillerosCircundantes(caja).get(i).obtenerElemento()==this)
			{
				cajaPegadaAAldeano = true;
			}
		}
		if(!cajaPegadaAAldeano)
		{
			throw new CajaNoEstaPegadaAAldeano("El aldeano debe limitar con el edificio que se desea construir");
		}


		this.turno.assertDisponibilidad();
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
		this.turno.finalizarAccion();
		
	}
	
	public void construirCuartel(Casillero casillero, Mapa mapa,Jugador jugador) throws casilleroInvalido, cajaEstaOcupada, CajaNoEstaPegadaAAldeano, PiezaDeshabilitadaEnTurno
    {
    	Caja caja = mapa.asignarCajaACasillero(casillero);
		boolean cajaPegadaAAldeano=false;
		for(int i=0;i<mapa.obtenerCasillerosCircundantes(caja).size();i++)
		{
			if(mapa.obtenerCasillerosCircundantes(caja).get(i).obtenerElemento()==this)
			{
				cajaPegadaAAldeano = true;
			}
		}
		if(!cajaPegadaAAldeano)
		{
			throw new CajaNoEstaPegadaAAldeano("El aldeano debe limitar con el edificio que se desea construir");
		}

		this.turno.assertDisponibilidad();
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
		this.turno.finalizarAccion();
		
	}

//	public void construirEdificio(Edificio edificio, Casillero casillero, Mapa mapa)
//    {
//		edificio = new Edificio()
//	}
	
	public void repararEdificio(Edificio unEdificio)
    {
		if (!unEdificio.reparacionCompleta()) {
			unEdificio.reparar();
			trabajando = true;
		} else {
			trabajando = false;
			this.recolectarOro();
		}
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

