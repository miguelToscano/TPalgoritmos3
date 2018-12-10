package unidades;
import excepciones.FueraDeRango;
import excepciones.NoEsElTurnoDelJugador;
import excepciones.PiezaDeshabilitadaEnTurno;
import excepciones.UnidadAliada;
import excepciones.superaLimitePoblacional;
import juego.Jugador;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.casilleroEstaOcupado;

public abstract class Militar extends Unidad
{
	protected int danioAUnidades;
	protected int danioAEdificios;
	protected int radioAtaque;

   // abstract void atacar();
    
    public Militar (int fila, int columna, Mapa mapa) throws casilleroEstaOcupado
	{
		super (fila, columna, mapa);
    }
	
    public Militar (Casillero casillero, Jugador jugador ) throws casilleroEstaOcupado,superaLimitePoblacional {
    	
    	super (casillero,jugador);
    }
    
    public abstract void ejecutarLogicaDeTurno();
    
    public void atacar (Entidad objetivo) throws FueraDeRango, UnidadAliada, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno
    {
    	// estos metodos lanzan la excepcion correspondiente, asi no esta lleno de ifs
    	
    	//this.jugador.assertTurno();  //es turno del jugador del cual es la nuidad
		this.turno.assertDisponibilidad(); // la unidad no se movio anteriormente
		this.assertUnidadEnemiga(objetivo); // la unidad objetivo a atacar no es aliada
		
    	if (! this.estaEnRango ( objetivo)) {
    		 throw new FueraDeRango();
    	}
    	objetivo.recibirDanio(this.danioAUnidades,this.danioAEdificios);
//    	this.turno.finalizarAccion();
    }
    
    
    public boolean estaEnRango ( Entidad objetivo) {
    		
    	return objetivo.estaEnRango(this.radioAtaque, this.casilleroOcupado);
    	}
    	
   public void assertUnidadEnemiga (Entidad objetivo) throws UnidadAliada {
	   if (this.jugador == objetivo.getJugador()) {
		   throw new UnidadAliada();
	   }
   }

}
//    
//    public void atacar (Edificio objetivo) throws FueraDeRango, UnidadAliada
//    {
//    	if (! this.estaEnRango (radioAtaque, objetivo)) {
//   		 throw new FueraDeRango();
//   	}
//   	//limitar turno
//    	objetivo.recibirDanio(this.danioAUnidades);
//    }

