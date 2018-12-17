package unidades;
import excepciones.FueraDeRango;
import excepciones.NoEsElTurnoDelJugador;
import excepciones.NoEstaMontada;
import excepciones.PiezaDeshabilitadaEnTurno;
import excepciones.UnidadAliada;
import excepciones.SuperaLimitePoblacional;
import juego.Jugador;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.casilleroEstaOcupado;

public abstract class Militar extends Unidad
{
	protected int danioAUnidades;
	protected int danioAEdificios;
	protected int radioAtaque;

	public boolean yaAtaco;
   // abstract void atacar();
    
    public Militar (int fila, int columna, Mapa mapa) throws casilleroEstaOcupado
    {
		super (fila, columna, mapa);
		this.yaAtaco = false;
    }
	
    public Militar (Casillero casillero, Jugador jugador ) throws casilleroEstaOcupado {
    	
    	super (casillero,jugador);
    	this.yaAtaco = false;
    }
    
    public Militar() {
    	super();
    	this.yaAtaco = false;
    }
    
    public abstract void ejecutarLogicaDeTurno();
  
    public abstract void atacar(Entidad objetivo) throws FueraDeRango, UnidadAliada, NoEsElTurnoDelJugador, PiezaDeshabilitadaEnTurno, NoEstaMontada;
    
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

